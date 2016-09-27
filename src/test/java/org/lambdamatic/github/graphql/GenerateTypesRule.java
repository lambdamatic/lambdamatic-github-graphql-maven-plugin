package org.lambdamatic.github.graphql;

import static java.util.Arrays.asList;
import static javax.tools.StandardLocation.CLASS_OUTPUT;
import static javax.tools.StandardLocation.SOURCE_OUTPUT;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticListener;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import org.junit.rules.ExternalResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * External resource that will call the {@link GitHubGraphQLTypesGenerator} to generate the .java files,
 * then compile into classes.
 */
public class GenerateTypesRule extends ExternalResource {

    /**
     * The logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(GenerateTypesRule.class);

    /**
     * the name of the JSON file containing the GraphQL schema.
     */
    private final String graphqlSchemaFile;

    /**
     * the name of the package in which the Java files will be generated, relative to the javaFilesTargetDir.
     */
    private final String packageName;

    /**
     * Constructor.
     *
     * @param graphqlSchemaFile the name of the JSON file containing the GraphQL schema
     * @param packageName       the name of the package in which the Java files will be generated,
     *                          relative to the javaFilesTargetDir
     */
    public GenerateTypesRule(final String graphqlSchemaFile, final String packageName) {
        this.graphqlSchemaFile = graphqlSchemaFile;
        this.packageName = packageName;
    }

    /**
     * Generates the Java files then compile them.
     *
     * @throws IOException if something went wrong while generating the Java files
     */
    @Override
    protected void before() throws IOException {
        // generate java files
        final InputStream graphQLSchemaInputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream(this.graphqlSchemaFile);
        final File javaFilesTargetDir = new File(new File(System.getProperty("user.dir")),
                "target/generated-sources/java");
        cleanDirectory(javaFilesTargetDir);
        new GitHubGraphQLTypesGenerator().generate(graphQLSchemaInputStream, javaFilesTargetDir,
                this.packageName);
        // clean the target directory for the classes
        final File classesTargetDir = new File(new File(System.getProperty("user.dir")),
                "target/test-classes");
        // compile java files
        compileJavaFiles(javaFilesTargetDir, classesTargetDir);
    }

    /**
     * Creates or cleans the {@code directory folder} before compiling the classes.
     *
     * @param directory the directory to create or clean
     * @throws IOException in case of problem when cleaning the directories
     */
    private void cleanDirectory(final File directory) throws IOException {
        if (directory.exists()) {
            if (directory.isFile()) {
                directory.delete();
                Files.createDirectory(directory.toPath());
            } else {
                Files.walk(directory.toPath(), Integer.MAX_VALUE,
                        FileVisitOption.FOLLOW_LINKS)
                        .filter(p -> !p.toFile().equals(directory))
                        .forEach(p -> p.toFile().delete());
            }
        } else {
            Files.createDirectory(directory.toPath());
        }
    }


    /**
     * Generated the meta classes before the given {@code domainClass} is compiled.
     *
     * @param javaFilesDir the base directory for the Java files to compile
     * @param targetDir    the target directory for the class files
     * @throws IOException if location is an output location and path does not represent an existing
     *                     directory
     */
    private void compileJavaFiles(final File javaFilesDir, final File targetDir) throws IOException {
        // configuration
        final JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        final CompilationDiagnosticListener diagnosticListener = new CompilationDiagnosticListener();
        final StandardJavaFileManager fileManager =
                compiler.getStandardFileManager(diagnosticListener, null, null);
        fileManager.setLocation(SOURCE_OUTPUT, asList(javaFilesDir));
        fileManager.setLocation(CLASS_OUTPUT, asList(targetDir));
        // locate Java files to compile
        final List<File> javaFilesToCompile = new ArrayList<>();
        final PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**.java");
        Files.walkFileTree(javaFilesDir.toPath(), new SimpleFileVisitor<Path>() {

            @Override
            public FileVisitResult visitFile(final Path path, final BasicFileAttributes attrs) throws IOException {
                if (matcher.matches(path)) {
                    javaFilesToCompile.add(path.toFile());
                } else {
                    LOGGER.warn("No match for {}", path.toString());
                }
                return super.visitFile(path, attrs);
            }

        });
        final Iterable<? extends JavaFileObject> filesToCompile =
                fileManager.getJavaFileObjectsFromFiles(javaFilesToCompile);
        // operation
        LOGGER.info("Compiling {} files in {}", javaFilesToCompile.size(), targetDir.toString());
        final JavaCompiler.CompilationTask basicCompilationTask =
                compiler.getTask(null, fileManager, diagnosticListener, null, null, filesToCompile);
        final boolean compiledWithoutErrors = basicCompilationTask.call();
        // verification
        assertThat(compiledWithoutErrors).as("Files compiled without errors").isTrue();
    }

    /**
     * Listens to annotation processing and compilation events and logs the relevant bits.
     */
    public static class CompilationDiagnosticListener implements DiagnosticListener<JavaFileObject> {

        @Override
        public void report(Diagnostic<? extends JavaFileObject> diagnostic) {
            switch (diagnostic.getKind()) {
                case NOTE:
                    LOGGER.debug("{}: {} at line {}", diagnostic.getKind(), diagnostic.getMessage(null),
                            diagnostic.getLineNumber());
                    break;
                case MANDATORY_WARNING:
                case WARNING:
                    LOGGER.warn("{}: {} at line {}", diagnostic.getKind(), diagnostic.getMessage(null),
                            diagnostic.getLineNumber());
                    break;
                case ERROR:
                    LOGGER.error("{}: {} at {}:{}", diagnostic.getKind(),
                            diagnostic.getMessage(null), (diagnostic.getSource() != null
                                    ? diagnostic.getSource().getName() : "unknown source"),
                            diagnostic.getLineNumber());
                    break;
                default:
                    LOGGER.info("{}: {} at line {}", diagnostic.getKind(), diagnostic.getMessage(null),
                            diagnostic.getLineNumber());
                    break;
            }
        }

    }
}

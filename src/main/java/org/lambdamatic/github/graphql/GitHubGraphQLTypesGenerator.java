package org.lambdamatic.github.graphql;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import org.lambdamatic.github.graphql.types.GitHubGraphQL;
import org.lambdamatic.github.graphql.types.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

/**
 * Generates the Java types (ie, the <code>.java</code> files) for all types declared in the public
 * GraphQL API.
 */
public class GitHubGraphQLTypesGenerator {

    private static final Logger LOGGER = LoggerFactory.getLogger(GitHubGraphQLTypesGenerator.class);

    private final MustacheFactory mf = new DefaultMustacheFactory();

    /**
     * Generates all GraphQL types from the given {@code jsonSchema}. The files are written in
     * the @{@code packageName} in the {@code targetDir}.
     *
     * @param jsonSchema  the GraphQL schema to parse
     * @param targetDir   the base directory in which the Java files will be written
     * @param packageName the name of the package for the files to be written, relative to the targetDir.
     * @throws IOException if something wrong happened while parsing the schema or while creating and
     *                     writing the output files.
     */
    public void generate(final InputStream jsonSchema, final File targetDir, final String packageName)
            throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        final GitHubGraphQL gitHubGraphQL = mapper.readValue(jsonSchema, GitHubGraphQL.class);
        LOGGER.info("Types: " + gitHubGraphQL.getData().getSchema().getTypes().size());
        // processing ENUM types
        gitHubGraphQL.getData().getSchema().getTypes().stream().filter(t -> t.getKind().equals("ENUM"))
                .forEach(t -> {
                            try {
                                generateJavaFile(targetDir, packageName, t,
                                        getTemplate("graphql-enum-template.mustache"));
                            } catch (IOException e) {
                                throw new RuntimeException("Failed to process " + t.getName(), e);
                            }
                        }
                );
        // processing INTERFACE types
        //    gitHubGraphQL.getData().getSchema().getTypes().stream().filter(t -> t.getKind().equals("INTERFACE"))
        //    .forEach(t -> {
        //      try {
        //        generateJavaFile(targetDir, packageName, t, getTemplate("graphql-interface-template.mustache"));
        //      } catch (IOException e) {
        //        throw new RuntimeException("Failed to process " + t.getName(), e);
        //      }
        //    }
        //    );

    }


    private void generateJavaFile(final File targetDir, final String packageName, final Type t,
                                  final Mustache template) throws IOException {
        final File javaFile = getTargetFile(targetDir, packageName, t);
        try (final FileWriter javaFileWriter = new FileWriter(javaFile)) {
            final List<Object> scopes = Arrays.asList(t, new TemplateContext(packageName));
            template.execute(javaFileWriter, scopes).flush();
        }
    }

    private File getTargetFile(final File targetDir, final String packageName, final Type t)
            throws IOException {
        final File javaFile = new File(targetDir,
                packageName.replaceAll("\\.", File.separator) + File.separator + t.getName() + ".java");
        LOGGER.info("Creating file {}", javaFile.getAbsolutePath());
        final File parentDirectory = new File(javaFile.getParent());
        if (!parentDirectory.exists()) {
            parentDirectory.mkdirs();
        }
        javaFile.createNewFile();
        return javaFile;
    }

    /**
     * Returns an instance of the {@link Mustache} identified by the given templateName.
     *
     * @param templateName the fully qualified name of the {@link Mustache} to return
     * @return the {@link Mustache}
     */
    private Mustache getTemplate(final String templateName) {
        return this.mf.compile(templateName);
    }

    public static class TemplateContext {

        private final String packageName;

        private final String processorClassName;

        public TemplateContext(final String packageName) {
            this.packageName = packageName;
            this.processorClassName = GitHubGraphQLTypesGenerator.class.getName();
        }

        public String getPackageName() {
            return packageName;
        }

        public String getProcessorClassName() {
            return processorClassName;
        }
    }

}

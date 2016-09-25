package org.lambdamatic.github.graphql.plugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;

import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Mojo( name = "generate", defaultPhase = LifecyclePhase.PROCESS_SOURCES )
public class GraphQLTypesGeneratorMojo extends AbstractMojo {
    /**
     * Location of the file.
     */
    @Parameter( defaultValue = "${project.build.directory}", property = "outputDir", required = true )
    private File outputDirectory;

    /**
     * Execute the Mojo.
     * @throws MojoExecutionException in case of problem
     */
    public void execute()
        throws MojoExecutionException {
        final File f = outputDirectory;
        if (!f.exists()) {
            f.mkdirs();
        }
    }
}

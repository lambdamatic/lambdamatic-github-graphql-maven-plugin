package org.lambdamatic.github.graphql;

import org.junit.ClassRule;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Testing the {@link GitHubGraphQLTypesGenerator} class.
 */
public class GitHubGraphQLTypesGeneratorTest {

    public static final String TYPES_PACKAGE_NAME = "org.lambdamatic.github.graphqlclient.types";

    // using a class rule to generate the java files and compile them
    @ClassRule
    public static GenerateTypesRule generateTypes = new GenerateTypesRule("github-graphql-schema.json",
            TYPES_PACKAGE_NAME);

    @Test
    public void verifyEnumerations() throws ClassNotFoundException {
        // given
        final Class<?> deploymentStateClass = Class.forName(TYPES_PACKAGE_NAME + ".DeploymentState");
        // then
        assertThat(deploymentStateClass.isEnum()).isTrue();
        assertThat(deploymentStateClass.getEnumConstants().length).isGreaterThan(0);

    }
}

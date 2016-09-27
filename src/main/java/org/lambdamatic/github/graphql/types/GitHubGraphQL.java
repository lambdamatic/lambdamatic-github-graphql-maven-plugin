package org.lambdamatic.github.graphql.types;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "data"
})
public class GitHubGraphQL {

    @JsonProperty("data")
    private Data data;

    /**
     * No args constructor for use in serialization.
     */
    public GitHubGraphQL() {
    }

    /**
     * Constructor.
     * @param data the graphql data
     */
    public GitHubGraphQL(Data data) {
        this.data = data;
    }

    /**
     * @return The data.
     */
    @JsonProperty("data")
    public Data getData() {
        return data;
    }

    /**
     * @param data The data.
     */
    @JsonProperty("data")
    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(data).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof GitHubGraphQL) == false) {
            return false;
        }
        GitHubGraphQL rhs = ((GitHubGraphQL) other);
        return new EqualsBuilder().append(data, rhs.data).isEquals();
    }

}

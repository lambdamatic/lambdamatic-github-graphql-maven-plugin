package org.lambdamatic.github.graphql.types;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "queryType",
        "mutationType",
        "subscriptionType",
        "types0",
        "directives"
})
public class Schema {

    @JsonProperty("queryType")
    private QueryType queryType;

    @JsonProperty("mutationType")
    private MutationType mutationType;

    @JsonProperty("subscriptionType")
    private Object subscriptionType;

    @JsonProperty("types")
    private List<Type> types = new ArrayList<>();

    @JsonProperty("directives")
    private List<Directive> directives = new ArrayList<>();

    /**
     * No args constructor for use in serialization.
     */
    public Schema() {
    }

    /**
     * Constructor.
     * @param queryType the query type
     * @param directives the directives
     * @param subscriptionType the subscription type
     * @param mutationType the mutation type
     * @param types the types
     */
    public Schema(QueryType queryType, MutationType mutationType, Object subscriptionType,
                  List<Type> types, List<Directive> directives) {
        this.queryType = queryType;
        this.mutationType = mutationType;
        this.subscriptionType = subscriptionType;
        this.types = types;
        this.directives = directives;
    }

    /**
     * @return The queryType.
     */
    @JsonProperty("queryType")
    public QueryType getQueryType() {
        return queryType;
    }

    /**
     * @param queryType The queryType.
     */
    @JsonProperty("queryType")
    public void setQueryType(QueryType queryType) {
        this.queryType = queryType;
    }

    /**
     * @return The mutationType.
     */
    @JsonProperty("mutationType")
    public MutationType getMutationType() {
        return mutationType;
    }

    /**
     * @param mutationType The mutationType.
     */
    @JsonProperty("mutationType")
    public void setMutationType(MutationType mutationType) {
        this.mutationType = mutationType;
    }

    /**
     * @return The subscriptionType.
     */
    @JsonProperty("subscriptionType")
    public Object getSubscriptionType() {
        return subscriptionType;
    }

    /**
     * @param subscriptionType The subscriptionType.
     */
    @JsonProperty("subscriptionType")
    public void setSubscriptionType(Object subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    /**
     * @return The types.
     */
    @JsonProperty("types0")
    public List<Type> getTypes() {
        return types;
    }

    /**
     * @param types The types.
     */
    @JsonProperty("types0")
    public void setTypes(List<Type> types) {
        this.types = types;
    }

    /**
     * @return The directives.
     */
    @JsonProperty("directives")
    public List<Directive> getDirectives() {
        return directives;
    }

    /**
     * @param directives The directives.
     */
    @JsonProperty("directives")
    public void setDirectives(List<Directive> directives) {
        this.directives = directives;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(queryType).append(mutationType).append(subscriptionType)
                .append(types).append(directives).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Schema) == false) {
            return false;
        }
        Schema rhs = ((Schema) other);
        return new EqualsBuilder().append(queryType, rhs.queryType).append(mutationType, rhs.mutationType)
                .append(subscriptionType, rhs.subscriptionType).append(types, rhs.types)
                .append(directives, rhs.directives).isEquals();
    }

}

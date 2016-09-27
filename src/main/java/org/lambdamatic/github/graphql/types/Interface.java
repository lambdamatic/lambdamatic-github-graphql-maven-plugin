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
        "kind",
        "name",
        "ofType"
})
public class Interface {

    @JsonProperty("kind")
    private String kind;

    @JsonProperty("name")
    private String name;

    @JsonProperty("ofType")
    private Object ofType;

    /**
     * No args constructor for use in serialization.
     */
    public Interface() {
    }

    /**
     * Constructor.
     * @param kind the interface type
     * @param name the name of the interface
     * @param ofType the type of the interface (for generic types)
     */
    public Interface(String kind, String name, Object ofType) {
        this.kind = kind;
        this.name = name;
        this.ofType = ofType;
    }

    /**
     * @return The kind.
     */
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    /**
     * @param kind The kind.
     */
    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * @return The name.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * @param name The name.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return The ofType.
     */
    @JsonProperty("ofType")
    public Object getOfType() {
        return ofType;
    }

    /**
     * @param ofType The ofType.
     */
    @JsonProperty("ofType")
    public void setOfType(Object ofType) {
        this.ofType = ofType;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(kind).append(name).append(ofType).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Interface) == false) {
            return false;
        }
        Interface rhs = ((Interface) other);
        return new EqualsBuilder().append(kind, rhs.kind).append(name, rhs.name)
                .append(ofType, rhs.ofType).isEquals();
    }

}

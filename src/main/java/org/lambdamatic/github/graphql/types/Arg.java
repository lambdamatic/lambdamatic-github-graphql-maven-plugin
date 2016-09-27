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
        "name",
        "description",
        "type",
        "defaultValue"
})
public class Arg {

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private Object description;

    @JsonProperty("type")
    private ArgType type;

    @JsonProperty("defaultValue")
    private Object defaultValue;

    /**
     * No args constructor for use in serialization.
     */
    public Arg() {
    }

    /**
     * Constructor.
     * @param name the argument name
     * @param description the description
     * @param type the type
     * @param defaultValue the default value
     */
    public Arg(String name, Object description, ArgType type, Object defaultValue) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.defaultValue = defaultValue;
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
     * @return The description.
     */
    @JsonProperty("description")
    public Object getDescription() {
        return description;
    }

    /**
     * @param description The description.
     */
    @JsonProperty("description")
    public void setDescription(Object description) {
        this.description = description;
    }

    /**
     * @return The type.
     */
    @JsonProperty("type")
    public ArgType getType() {
        return type;
    }

    /**
     * @param type The type.
     */
    @JsonProperty("type")
    public void setType(ArgType type) {
        this.type = type;
    }

    /**
     * @return The defaultValue.
     */
    @JsonProperty("defaultValue")
    public Object getDefaultValue() {
        return defaultValue;
    }

    /**
     * @param defaultValue The defaultValue.
     */
    @JsonProperty("defaultValue")
    public void setDefaultValue(Object defaultValue) {
        this.defaultValue = defaultValue;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(name).append(description).append(type).append(defaultValue).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Arg) == false) {
            return false;
        }
        Arg rhs = ((Arg) other);
        return new EqualsBuilder().append(name, rhs.name).append(description, rhs.description)
                .append(type, rhs.type).append(defaultValue, rhs.defaultValue).isEquals();
    }

}

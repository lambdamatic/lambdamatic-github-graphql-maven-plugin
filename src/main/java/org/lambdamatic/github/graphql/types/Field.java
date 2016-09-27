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
        "name",
        "description",
        "args",
        "type",
        "isDeprecated",
        "deprecationReason"
})
public class Field {

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("args")
    private List<Object> args = new ArrayList<>();

    @JsonProperty("type")
    private FieldType type;

    @JsonProperty("isDeprecated")
    private boolean isDeprecated;

    @JsonProperty("deprecationReason")
    private Object deprecationReason;

    /**
     * No args constructor for use in serialization.
     */
    public Field() {
    }

    /**
     * Constructor.
     * @param name the field name
     * @param description the description
     * @param args the field arguments
     * @param type the field type
     * @param isDeprecated marker if the field is deprecated
     * @param deprecationReason the reason why the field is deprecated
     */
    public Field(String name, String description, List<Object> args, FieldType type, boolean isDeprecated,
                 Object deprecationReason) {
        this.name = name;
        this.description = description;
        this.args = args;
        this.type = type;
        this.isDeprecated = isDeprecated;
        this.deprecationReason = deprecationReason;
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
    public String getDescription() {
        return description;
    }

    /**
     * @param description The description.
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return The args.
     */
    @JsonProperty("args")
    public List<Object> getArgs() {
        return args;
    }

    /**
     * @param args The args.
     */
    @JsonProperty("args")
    public void setArgs(List<Object> args) {
        this.args = args;
    }

    /**
     * @return The type.
     */
    @JsonProperty("type")
    public FieldType getType() {
        return type;
    }

    /**
     * @param type The type.
     */
    @JsonProperty("type")
    public void setType(FieldType type) {
        this.type = type;
    }

    /**
     * @return The isDeprecated.
     */
    @JsonProperty("isDeprecated")
    public boolean isIsDeprecated() {
        return isDeprecated;
    }

    /**
     * @param isDeprecated The isDeprecated.
     */
    @JsonProperty("isDeprecated")
    public void setIsDeprecated(boolean isDeprecated) {
        this.isDeprecated = isDeprecated;
    }

    /**
     * @return The deprecationReason.
     */
    @JsonProperty("deprecationReason")
    public Object getDeprecationReason() {
        return deprecationReason;
    }

    /**
     * @param deprecationReason The deprecationReason.
     */
    @JsonProperty("deprecationReason")
    public void setDeprecationReason(Object deprecationReason) {
        this.deprecationReason = deprecationReason;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(name).append(description).append(args).append(type)
                .append(isDeprecated).append(deprecationReason).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Field) == false) {
            return false;
        }
        Field rhs = ((Field) other);
        return new EqualsBuilder().append(name, rhs.name).append(description, rhs.description)
                .append(args, rhs.args).append(type, rhs.type).append(isDeprecated, rhs.isDeprecated)
                .append(deprecationReason, rhs.deprecationReason).isEquals();
    }

}

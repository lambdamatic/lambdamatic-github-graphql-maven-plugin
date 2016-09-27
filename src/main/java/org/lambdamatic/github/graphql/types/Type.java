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
        "kind",
        "name",
        "description",
        "fields",
        "inputFields",
        "interfaces",
        "enumValues",
        "possibleTypes"
})
public class Type {

    @JsonProperty("kind")
    private String kind;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("fields")
    private List<Field> fields = new ArrayList<>();

    @JsonProperty("inputFields")
    private Object inputFields;

    @JsonProperty("interfaces")
    private List<Interface> interfaces = new ArrayList<>();

    @JsonProperty("enumValues")
    private Object enumValues;

    @JsonProperty("possibleTypes")
    private Object possibleTypes;

    /**
     * No args constructor for use in serialization.
     */
    public Type() {
    }

    /**
     * Constructor.
     * @param kind the kind of type
     * @param name the name of the type
     * @param description the description
     * @param fields the fields
     * @param inputFields the imput fields
     * @param interfaces the interfaces of the type
     * @param enumValues the values if the type is an enum
     * @param possibleTypes the possible types if the type is a union
     */
    public Type(String kind, String name, String description, List<Field> fields, Object inputFields,
                List<Interface> interfaces, Object enumValues, Object possibleTypes) {
        this.kind = kind;
        this.name = name;
        this.description = description;
        this.fields = fields;
        this.inputFields = inputFields;
        this.interfaces = interfaces;
        this.enumValues = enumValues;
        this.possibleTypes = possibleTypes;
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
     * @return The fields.
     */
    @JsonProperty("fields")
    public List<Field> getFields() {
        return fields;
    }

    /**
     * @param fields The fields.
     */
    @JsonProperty("fields")
    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    /**
     * @return The inputFields.
     */
    @JsonProperty("inputFields")
    public Object getInputFields() {
        return inputFields;
    }

    /**
     * @param inputFields The inputFields.
     */
    @JsonProperty("inputFields")
    public void setInputFields(Object inputFields) {
        this.inputFields = inputFields;
    }

    /**
     * @return The interfaces.
     */
    @JsonProperty("interfaces")
    public List<Interface> getInterfaces() {
        return interfaces;
    }

    /**
     * @param interfaces The interfaces.
     */
    @JsonProperty("interfaces")
    public void setInterfaces(List<Interface> interfaces) {
        this.interfaces = interfaces;
    }

    /**
     * @return The enumValues.
     */
    @JsonProperty("enumValues")
    public Object getEnumValues() {
        return enumValues;
    }

    /**
     * @param enumValues The enumValues.
     */
    @JsonProperty("enumValues")
    public void setEnumValues(Object enumValues) {
        this.enumValues = enumValues;
    }

    /**
     * @return The possibleTypes.
     */
    @JsonProperty("possibleTypes")
    public Object getPossibleTypes() {
        return possibleTypes;
    }

    /**
     * @param possibleTypes The possibleTypes.
     */
    @JsonProperty("possibleTypes")
    public void setPossibleTypes(Object possibleTypes) {
        this.possibleTypes = possibleTypes;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(kind).append(name).append(description).append(fields)
                .append(inputFields).append(interfaces).append(enumValues).append(possibleTypes).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Type) == false) {
            return false;
        }
        Type rhs = ((Type) other);
        return new EqualsBuilder().append(kind, rhs.kind).append(name, rhs.name)
                .append(description, rhs.description).append(fields, rhs.fields)
                .append(inputFields, rhs.inputFields).append(interfaces, rhs.interfaces)
                .append(enumValues, rhs.enumValues).append(possibleTypes, rhs.possibleTypes).isEquals();
    }

}

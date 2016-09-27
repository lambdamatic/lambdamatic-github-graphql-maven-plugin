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
        "__schema"
})
public class Data {

    @JsonProperty("__schema")
    private Schema schema;

    /**
     * No args constructor for use in serialization.
     */
    public Data() {
    }

    /**
     * Constructor.
     * @param schema the schema
     */
    public Data(Schema schema) {
        this.schema = schema;
    }

    /**
     * @return The schema.
     */
    @JsonProperty("__schema")
    public Schema getSchema() {
        return schema;
    }

    /**
     * @param schema The __schema.
     */
    @JsonProperty("__schema")
    public void setSchema(Schema schema) {
        this.schema = schema;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(schema).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Data) == false) {
            return false;
        }
        Data rhs = ((Data) other);
        return new EqualsBuilder().append(schema, rhs.schema).isEquals();
    }

}

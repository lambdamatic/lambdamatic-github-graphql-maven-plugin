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
        "locations",
        "args"
})
public class Directive {

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("locations")
    private List<String> locations = new ArrayList<String>();

    @JsonProperty("args")
    private List<Arg> args = new ArrayList<Arg>();

    /**
     * No args constructor for use in serialization.
     */
    public Directive() {
    }

    /**
     * Constructor.
     * @param name the name
     * @param description the description
     * @param locations the locations
     * @param args the args
     */
    public Directive(String name, String description, List<String> locations, List<Arg> args) {
        this.name = name;
        this.description = description;
        this.locations = locations;
        this.args = args;
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
     * @return The locations.
     */
    @JsonProperty("locations")
    public List<String> getLocations() {
        return locations;
    }

    /**
     * @param locations The locations.
     */
    @JsonProperty("locations")
    public void setLocations(List<String> locations) {
        this.locations = locations;
    }

    /**
     * @return The args.
     */
    @JsonProperty("args")
    public List<Arg> getArgs() {
        return args;
    }

    /**
     * @param args The args.
     */
    @JsonProperty("args")
    public void setArgs(List<Arg> args) {
        this.args = args;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(name).append(description).append(locations).append(args).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Directive) == false) {
            return false;
        }
        Directive rhs = ((Directive) other);
        return new EqualsBuilder().append(name, rhs.name).append(description, rhs.description)
                .append(locations, rhs.locations).append(args, rhs.args).isEquals();
    }

}

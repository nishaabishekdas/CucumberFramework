
package com.api.model.viewStoreModel;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "createdAt",
    "storeId",
    "serviceId",
    "updatedAt"
})
@Generated("jsonschema2pojo")
public class Storeservices {

    @JsonProperty("createdAt")
    private String createdAt;
    @JsonProperty("storeId")
    private Integer storeId;
    @JsonProperty("serviceId")
    private Integer serviceId;
    @JsonProperty("updatedAt")
    private String updatedAt;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("createdAt")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("createdAt")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Storeservices withCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    @JsonProperty("storeId")
    public Integer getStoreId() {
        return storeId;
    }

    @JsonProperty("storeId")
    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Storeservices withStoreId(Integer storeId) {
        this.storeId = storeId;
        return this;
    }

    @JsonProperty("serviceId")
    public Integer getServiceId() {
        return serviceId;
    }

    @JsonProperty("serviceId")
    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Storeservices withServiceId(Integer serviceId) {
        this.serviceId = serviceId;
        return this;
    }

    @JsonProperty("updatedAt")
    public String getUpdatedAt() {
        return updatedAt;
    }

    @JsonProperty("updatedAt")
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Storeservices withUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Storeservices withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Storeservices.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("createdAt");
        sb.append('=');
        sb.append(((this.createdAt == null)?"<null>":this.createdAt));
        sb.append(',');
        sb.append("storeId");
        sb.append('=');
        sb.append(((this.storeId == null)?"<null>":this.storeId));
        sb.append(',');
        sb.append("serviceId");
        sb.append('=');
        sb.append(((this.serviceId == null)?"<null>":this.serviceId));
        sb.append(',');
        sb.append("updatedAt");
        sb.append('=');
        sb.append(((this.updatedAt == null)?"<null>":this.updatedAt));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.createdAt == null)? 0 :this.createdAt.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.storeId == null)? 0 :this.storeId.hashCode()));
        result = ((result* 31)+((this.serviceId == null)? 0 :this.serviceId.hashCode()));
        result = ((result* 31)+((this.updatedAt == null)? 0 :this.updatedAt.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Storeservices) == false) {
            return false;
        }
        Storeservices rhs = ((Storeservices) other);
        return ((((((this.createdAt == rhs.createdAt)||((this.createdAt!= null)&&this.createdAt.equals(rhs.createdAt)))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.storeId == rhs.storeId)||((this.storeId!= null)&&this.storeId.equals(rhs.storeId))))&&((this.serviceId == rhs.serviceId)||((this.serviceId!= null)&&this.serviceId.equals(rhs.serviceId))))&&((this.updatedAt == rhs.updatedAt)||((this.updatedAt!= null)&&this.updatedAt.equals(rhs.updatedAt))));
    }

}

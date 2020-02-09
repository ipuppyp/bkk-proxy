
package com.ipuppyp.bkkproxy.delegate.scheduleforstop.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "limitExceeded",
    "entry"
})
@JsonIgnoreProperties(ignoreUnknown = true)
@lombok.Data
public class Data {

    @JsonProperty("limitExceeded")
    private Boolean limitExceeded;
    @JsonProperty("entry")
    private  Entry entry;

}

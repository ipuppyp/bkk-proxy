
package com.ipuppyp.bkkproxy.delegate.scheduleforstop.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "routeId",
    "alertIds",
    "directions"
})
@JsonIgnoreProperties(ignoreUnknown = true)
@lombok.Data
public class Schedule {

    @JsonProperty("routeId")
    private String routeId;
    @JsonProperty("directions")
    private List<Direction> directions = null;

}

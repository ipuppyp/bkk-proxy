
package com.ipuppyp.bkkproxy.delegate.scheduleforstop.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "directionId",
    "stopTimes"
})
@JsonIgnoreProperties(ignoreUnknown = true)
@lombok.Data
public class Direction {

    @JsonProperty("directionId")
    private String directionId;
    @JsonProperty("stopTimes")
    private List<StopTime> stopTimes;

}

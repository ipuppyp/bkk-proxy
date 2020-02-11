
package com.ipuppyp.bkkproxy.delegate.domain.scheduleforstop;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "stopId",
    "serviceDate",
    "schedules"
})
@JsonIgnoreProperties(ignoreUnknown = true)
@lombok.Data
public class Entry {

    @JsonProperty("stopId")
    private String stopId;
    @JsonProperty("serviceDate")
    private String serviceDate;
    @JsonProperty("schedules")
    private List<Schedule> schedules;

}

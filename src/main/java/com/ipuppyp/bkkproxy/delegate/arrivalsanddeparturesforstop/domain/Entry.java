package com.ipuppyp.bkkproxy.delegate.arrivalsanddeparturesforstop.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "stopId", "routeIds", "alertIds", "nearbyStopIds", "stopTimes" })
@JsonIgnoreProperties(ignoreUnknown = true)
@lombok.Data
public class Entry {

	@JsonProperty("stopId")
	private String stopId;
	@JsonProperty("stopTimes")
	private List<StopTime> stopTimes = null;
}

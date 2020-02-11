package com.ipuppyp.bkkproxy.delegate.domain.arrivalsanddeparturesforstop;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "routeId", "shapeId", "tripHeadsign", "serviceId", "directionId", "bikesAllowed",
		"wheelchairAccessible" })
@JsonIgnoreProperties(ignoreUnknown = true)
@lombok.Data
public class Trip {

	@JsonProperty("id")
	private String id;
	@JsonProperty("routeId")
	private String routeId;
	@JsonProperty("shapeId")
	private String shapeId;
	@JsonProperty("tripHeadsign")
	private String tripHeadsign;
	@JsonProperty("serviceId")
	private String serviceId;
	@JsonProperty("directionId")
	private String directionId;
	@JsonProperty("bikesAllowed")
	private Boolean bikesAllowed;
	@JsonProperty("wheelchairAccessible")
	private Boolean wheelchairAccessible;
}

package com.ipuppyp.bkkproxy.delegate.domain.arrivalsanddeparturesforstop;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "stopHeadsign", "arrivalTime", "departureTime", "predictedArrivalTime", "predictedDepartureTime",
		"tripId", "serviceDate" })
@lombok.Data
public class StopTime {

	@JsonProperty("stopHeadsign")
	private String stopHeadsign;
	@JsonProperty("arrivalTime")
	private Integer arrivalTime;
	@JsonProperty("departureTime")
	private Integer departureTime;
	@JsonProperty("predictedArrivalTime")
	private Integer predictedArrivalTime;
	@JsonProperty("predictedDepartureTime")
	private Integer predictedDepartureTime;
	@JsonProperty("tripId")
	private String tripId;
	@JsonProperty("serviceDate")
	private String serviceDate;
}

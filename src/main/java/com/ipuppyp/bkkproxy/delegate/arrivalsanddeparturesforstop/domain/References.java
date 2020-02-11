package com.ipuppyp.bkkproxy.delegate.arrivalsanddeparturesforstop.domain;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "trips" })
@JsonIgnoreProperties(ignoreUnknown = true)
@lombok.Data
public class References {


	@JsonProperty("trips")
	private Map<String, Trip> trips;
}

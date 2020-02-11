package com.ipuppyp.bkkproxy.delegate.domain.arrivalsanddeparturesforstop;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "version", "status", "code", "text", "currentTime", "data" })
@JsonIgnoreProperties(ignoreUnknown = true)
@lombok.Data
public class ArrivalsAndDeparturesForStop {

	@JsonProperty("version")
	private Integer version;
	@JsonProperty("status")
	private String status;
	@JsonProperty("code")
	private Integer code;
	@JsonProperty("text")
	private String text;
	@JsonProperty("currentTime")
	private Long currentTime;
	@JsonProperty("data")
	private Data data;
}

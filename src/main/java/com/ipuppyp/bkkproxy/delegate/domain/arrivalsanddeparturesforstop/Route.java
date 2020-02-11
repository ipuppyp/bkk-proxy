package com.ipuppyp.bkkproxy.delegate.domain.arrivalsanddeparturesforstop;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "shortName", "description", "type", "color", "textColor", "agencyId", "iconDisplayType",
		"iconDisplayText", "bikesAllowed"})
@JsonIgnoreProperties(ignoreUnknown = true)
@lombok.Data
public class Route {

	@JsonProperty("id")
	private String id;
	@JsonProperty("shortName")
	private String shortName;
	@JsonProperty("description")
	private String description;
	@JsonProperty("type")
	private String type;
	@JsonProperty("color")
	private String color;
	@JsonProperty("textColor")
	private String textColor;
	@JsonProperty("agencyId")
	private String agencyId;
	@JsonProperty("iconDisplayType")
	private String iconDisplayType;
	@JsonProperty("iconDisplayText")
	private String iconDisplayText;
	@JsonProperty("bikesAllowed")
	private Boolean bikesAllowed;
}
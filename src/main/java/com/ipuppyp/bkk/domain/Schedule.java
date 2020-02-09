package com.ipuppyp.bkk.domain;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Schedule {

	@EqualsAndHashCode.Include
	private String stopHeadsign;
	
	private String shortName;
	
	private LocalDateTime predictedDepartureTime;
	
}

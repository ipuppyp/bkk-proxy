package com.ipuppyp.bkk.domain;

import java.util.Collection;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Stop {

	@EqualsAndHashCode.Include
	private String stopId;
	
	private String name;
	
	private Collection<Schedule> schedules;
	
}

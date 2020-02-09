package com.ipuppyp.bkk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;


@Entity(name = "Stop")
@Data
public class StopEntity {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(unique = true)
	@NotNull
	private String name;
	
	@Column(unique = true)
	@NotNull
	private String stopId;
	
	@NotNull
	private Boolean enabled;
}

package com.ipuppyp.bkk.service;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipuppyp.bkk.domain.Stop;
import com.ipuppyp.bkk.entity.StopEntity;
import com.ipuppyp.bkk.repository.StopRepository;

@Service
public class ScheduleForStopService {

	@Autowired
	private StopRepository stopRepository;
	
	public Collection<Stop> findAllSchedules() {
		Collection<Stop> schedules = new HashSet<Stop>();
		Collection<StopEntity> stopEntities = stopRepository.findAll();
		
		stopEntities.forEach(stopEntity -> {
			Stop stop = new Stop();
			stop.setStopId(stopEntity.getStopId());
			stop.setName(stopEntity.getName());
			schedules.add(stop);
		});
		
		
		
		return schedules;
	}
}

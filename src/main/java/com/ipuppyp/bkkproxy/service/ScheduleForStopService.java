package com.ipuppyp.bkkproxy.service;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipuppyp.bkkproxy.delegate.ScheduleForStopBusinessApiDelegate;
import com.ipuppyp.bkkproxy.domain.Stop;
import com.ipuppyp.bkkproxy.entity.StopEntity;
import com.ipuppyp.bkkproxy.repository.StopRepository;
import com.ipuppyp.bkkproxy.transformer.ScheduleForStopToStopTransformer;

@Service
public class ScheduleForStopService {

	@Autowired
	private StopRepository stopRepository;

	@Autowired
	ScheduleForStopBusinessApiDelegate scheduleForStopBusinessApiDelegate;

	@Autowired
	ScheduleForStopToStopTransformer scheduleForStopToStopTransformer;
	
	public Collection<Stop> findAllSchedules() {
		
		Collection<StopEntity> stopEntities = stopRepository.findByEnabledTrue();
		Collection<Stop> stops = new HashSet<Stop>();
		
		stopEntities.forEach(stopEntity -> {
			stops.add(scheduleForStopToStopTransformer.transform(stopEntity, scheduleForStopBusinessApiDelegate.delegate(stopEntity.getStopId())));
		});
		return stops;
	}
}

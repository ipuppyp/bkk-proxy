package com.ipuppyp.bkkproxy.service;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipuppyp.bkkproxy.delegate.ArrivalsAndDeparturesForStopApiDelegate;
import com.ipuppyp.bkkproxy.domain.Stop;
import com.ipuppyp.bkkproxy.entity.StopEntity;
import com.ipuppyp.bkkproxy.repository.StopRepository;
import com.ipuppyp.bkkproxy.service.transformer.ArrivalsAndDeparturesForStopToStopTransformer;

@Service
public class ArrivalsAndDeparturesForStopService {

	@Autowired
	private StopRepository stopRepository;

	@Autowired
	ArrivalsAndDeparturesForStopApiDelegate arrivalsAndDeparturesForStopApiDelegate;

	@Autowired
	ArrivalsAndDeparturesForStopToStopTransformer arrivAndDeparturesToStopTransformer;
	
	public Collection<Stop> findAllStops() {
		
		Collection<StopEntity> stopEntities = stopRepository.findByEnabledTrue();
		Collection<Stop> stops = new HashSet<Stop>();
		
		stopEntities.forEach(stopEntity -> {
			stops.add(arrivAndDeparturesToStopTransformer.transform(stopEntity,
					arrivalsAndDeparturesForStopApiDelegate.delegate(stopEntity.getStopId())));
		});
		return stops;
	}
}

package com.ipuppyp.bkkproxy.service.transformer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.ipuppyp.bkkproxy.delegate.domain.arrivalsanddeparturesforstop.ArrivalsAndDeparturesForStop;
import com.ipuppyp.bkkproxy.delegate.domain.arrivalsanddeparturesforstop.Data;
import com.ipuppyp.bkkproxy.delegate.domain.arrivalsanddeparturesforstop.Route;
import com.ipuppyp.bkkproxy.delegate.domain.arrivalsanddeparturesforstop.Trip;
import com.ipuppyp.bkkproxy.domain.Stop;
import com.ipuppyp.bkkproxy.domain.StopTime;
import com.ipuppyp.bkkproxy.entity.StopEntity;

@Component
public class ArrivalsAndDeparturesForStopToStopTransformer {

	public Stop transform(StopEntity stopEntity, ArrivalsAndDeparturesForStop arrivalsAndDeparturesForStop) {
		
		Integer currentTime = (int)(arrivalsAndDeparturesForStop.getCurrentTime() / 1000);		
		Stop stop = new Stop();
		stop.setName(stopEntity.getName());
		stop.setStopId(stopEntity.getStopId());

		List<StopTime> stopTimes = new ArrayList<>();
		stop.setStopTimes(stopTimes);
		
		Data restData = arrivalsAndDeparturesForStop.getData();		
		Collection<Trip> restTrips = restData.getReferences().getTrips().values();
		Collection<Route> restRoutes = restData.getReferences().getRoutes().values();
		List<com.ipuppyp.bkkproxy.delegate.domain.arrivalsanddeparturesforstop.StopTime> restStopTimes = restData.getEntry().getStopTimes();
		
		
		restRoutes.forEach(r -> {
			List<String> tripsOfRoute =  restTrips
				.stream()
				.filter(t -> t.getRouteId().equals(r.getId()))
				.map(t -> t.getId()).collect(Collectors.toList());

			if (!tripsOfRoute.isEmpty()) {				
				String departuresInMins = restStopTimes.stream()
						.filter(st -> tripsOfRoute.contains(st.getTripId()))
						.limit(2)
						.map(st -> calculateDepartureInMins(currentTime, st))
						.collect(Collectors.joining(","));
				
				String stopHeadSign = restStopTimes.stream()
						.filter(st -> tripsOfRoute.contains(st.getTripId())).findAny().get().getStopHeadsign();
				
				StopTime stopTime = new StopTime();
				stopTime.setDeparturesInMins(departuresInMins);
				stopTime.setTripHeadsign(stopHeadSign);
				stopTime.setRouteId(r.getIconDisplayText());
				stop.getStopTimes().add(stopTime);
			}
		});
		return stop;
	}

	private String calculateDepartureInMins(Integer currentTime,
			com.ipuppyp.bkkproxy.delegate.domain.arrivalsanddeparturesforstop.StopTime st) {
		return Integer.toString((getDepartureTime(st) - currentTime) / 60);
	}
	
	private Integer getDepartureTime(com.ipuppyp.bkkproxy.delegate.domain.arrivalsanddeparturesforstop.StopTime stopTime) {
		return stopTime.getPredictedDepartureTime() != null ? 
						stopTime.getPredictedDepartureTime() :
						stopTime.getDepartureTime();
	}
	


}

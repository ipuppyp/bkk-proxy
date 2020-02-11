package com.ipuppyp.bkkproxy.service.transformer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.ipuppyp.bkkproxy.delegate.domain.scheduleforstop.ScheduleForStop;
import com.ipuppyp.bkkproxy.domain.Stop;
import com.ipuppyp.bkkproxy.domain.StopTime;
import com.ipuppyp.bkkproxy.entity.StopEntity;

@Component
public class ScheduleForStopToStopTransformer {

	private static final int ROUTE_INTERVAL = 3000; //TODO: move to config
	private static final int ROUTE_LIMIT = 2; //TODO: move to config
	
	public Stop transform(StopEntity stopEntity, ScheduleForStop scheduleForStop) {
		
		
		Integer currentTime = (int)(scheduleForStop.getCurrentTime() / 1000);
		Stop stop = new Stop();
		stop.setName(stopEntity.getName());
		stop.setStopId(stopEntity.getStopId());

		List<StopTime> stopTimes = new ArrayList<>();
		stop.setStopTimes(stopTimes);
		
		scheduleForStop.getData().getEntry().getSchedules().forEach(schedule -> {
			schedule.getDirections().forEach(direction -> {
				StopTime myStopTime = new StopTime();					
				myStopTime.setRouteId(schedule.getRouteId());					
				
				String departureTimes = direction.getStopTimes()
					.stream()
					.filter(st -> st.getDepartureTime() > currentTime && st.getDepartureTime() < currentTime + ROUTE_INTERVAL) 
					.limit(ROUTE_LIMIT) 
					.map(stopTime -> Integer.toString((getDepartureTime(stopTime) - currentTime) / 60))
					.collect(Collectors.joining(","));
				if (!departureTimes.isEmpty()) {
					myStopTime.setTripHeadsign(direction.getStopTimes().get(0).getStopHeadsign());
					myStopTime.setDeparturesInMins(departureTimes);
					stopTimes.add(myStopTime);
				}
			});
		});
		return stop;
	}

	private Integer getDepartureTime(com.ipuppyp.bkkproxy.delegate.domain.scheduleforstop.StopTime stopTime) {
		return stopTime.getPredictedDepartureTime() != null ? 
						stopTime.getPredictedDepartureTime() :
						stopTime.getDepartureTime();
	}
}

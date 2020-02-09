package com.ipuppyp.bkkproxy.transformer;

import java.util.Collection;
import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.ipuppyp.bkkproxy.domain.Stop;

@Component
public class StopToPlainTextTransformer {

	RouteIdToNumberMap routeIdToNumberMap = new RouteIdToNumberMap();
	
	public String transform(Collection<Stop> schedules) {
		StringBuffer result = new StringBuffer();
		schedules.forEach(stop -> {
			stop.getStopTimes().forEach(stopTime -> {
				int placeForStopHeadSign = 16 - 5 - stopTime.getDeparturesInMins().length();
				if (placeForStopHeadSign < 0) placeForStopHeadSign = 0;
				result
					.append(routeIdToNumberMap.get(stopTime.getRouteId()))
					.append(" ")
					.append(stopTime.getStopHeadsign().substring(0, placeForStopHeadSign))
					.append(" ")
					.append(stopTime.getDeparturesInMins())
					.append("\n");		
			});
		});
		return result.toString();
	}
}


class RouteIdToNumberMap extends HashMap<String,String> {

	//TODO: a better solution, eg, spring config.
	public RouteIdToNumberMap() {
		this.put("BKK_1310", "131");
		this.put("BKK_1300", "130");
		this.put("BKK_1440", "144");
		this.put("BKK_2310", "231");
		this.put("BKK_9070", "907");
		this.put("BKK_4800", "80 ");
		this.put("BKK_4801", "80A");
		this.put("BKK_4820", "82 ");
	}
}
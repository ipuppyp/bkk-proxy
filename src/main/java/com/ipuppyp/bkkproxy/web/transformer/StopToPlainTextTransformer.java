package com.ipuppyp.bkkproxy.web.transformer;

import static com.google.common.base.Strings.padStart;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Component;

import com.ipuppyp.bkkproxy.domain.Stop;
import com.ipuppyp.bkkproxy.domain.StopTime;

@Component
public class StopToPlainTextTransformer {

	
	private static final int NUMBER_OF_SPACES = 2;
	private static final String DATE_FORMAT = "yyyy/MM/dd HH:mm";

	public String transform(Collection<Stop> schedules) {
		StringBuilder result = new StringBuilder();
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(DATE_FORMAT);
		result.append(dtf.format(ZonedDateTime.now(ZoneId.of("Europe/Paris"))));
		result.append("\n");
		int maxLengthIconDisplayText = maxLengthIconDisplayText(schedules);
		schedules.forEach(stop -> {
			
			stop.getStopTimes().forEach(stopTime -> {
				int placeForStopHeadSign = 16 - maxLengthIconDisplayText - NUMBER_OF_SPACES - stopTime.getDeparturesInMins().length();
				if (placeForStopHeadSign < 0) placeForStopHeadSign = 0;
				result
					.append(padStart(stopTime.getIconDisplayText(), maxLengthIconDisplayText, ' '))
					.append(" ")
					.append(getStopHeadSign(stopTime, placeForStopHeadSign))
					.append(" ")
					.append(stopTime.getDeparturesInMins())
					.append("\n");
			});
		});	
		return result.toString();
	}

	private String getStopHeadSign(StopTime stopTime, int placeForStopHeadSign) {
		return stopTime.getStopHeadsign().replace('\u00A0',' ').trim().substring(0, placeForStopHeadSign).toUpperCase();
	}
	
	private int maxLengthIconDisplayText(Collection<Stop> stop) {
		return stop.stream().flatMap(s -> s.getStopTimes().stream()).map(StopTime::getIconDisplayText).mapToInt(String::length).max().orElse(0);
	}

}
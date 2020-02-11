package com.ipuppyp.bkkproxy.web.transformer;

import java.util.Collection;

import org.springframework.stereotype.Component;

import com.ipuppyp.bkkproxy.domain.Stop;

@Component
public class StopToPlainTextTransformer {

	
	public String transform(Collection<Stop> schedules) {
		StringBuilder result = new StringBuilder();
		schedules.forEach(stop -> {
			stop.getStopTimes().forEach(stopTime -> {
				int placeForStopHeadSign = 16 - 5 - stopTime.getDeparturesInMins().length();
				if (placeForStopHeadSign < 0) placeForStopHeadSign = 0;
				result
					.append(stopTime.getRouteId())
					.append(" ")
					.append(stopTime.getTripHeadsign().substring(0, placeForStopHeadSign))
					.append(" ")
					.append(stopTime.getDeparturesInMins())
					.append("\n");		
			});
		});
		replaceUniCodeChars(result);
		return result.toString();
	}
	
	private void replaceUniCodeChars(StringBuilder str) {
		replaceUniCodeChars(str, 'á', 'a');
		replaceUniCodeChars(str, 'Á', 'A');
		replaceUniCodeChars(str, 'é', 'e');
		replaceUniCodeChars(str, 'É', 'e');
		replaceUniCodeChars(str, 'í', 'i');
		replaceUniCodeChars(str, 'Í', 'I');
		replaceUniCodeChars(str, 'ó', 'o');
		replaceUniCodeChars(str, 'Ó', 'ó');
		replaceUniCodeChars(str, 'ö', 'o');
		replaceUniCodeChars(str, 'Ö', 'O');
		replaceUniCodeChars(str, 'ő', 'o');
		replaceUniCodeChars(str, 'Ő', 'o');
		replaceUniCodeChars(str, 'ü', 'u');
		replaceUniCodeChars(str, 'Ü', 'U');
		replaceUniCodeChars(str, 'ű', 'u');
		replaceUniCodeChars(str, 'Ű', 'u');
	}

	void replaceUniCodeChars(StringBuilder str, char from, char to) {
		for (int index = 0; index < str.length(); index++) {
		    if (str.charAt(index) == from) {
		    	str.setCharAt(index, to);
		    }
		}
	}
	
	
}
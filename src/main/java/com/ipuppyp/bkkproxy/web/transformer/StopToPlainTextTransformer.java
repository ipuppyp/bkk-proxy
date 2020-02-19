package com.ipuppyp.bkkproxy.web.transformer;

import static com.google.common.base.Strings.padStart;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

import org.springframework.stereotype.Component;

import com.ipuppyp.bkkproxy.domain.Stop;

@Component
public class StopToPlainTextTransformer {

	
	private static final String DATE_FORMAT = "yyyy/MM/dd HH:mm";

	public String transform(Collection<Stop> schedules) {
		StringBuilder result = new StringBuilder();
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(DATE_FORMAT);
		result.append(dtf.format(ZonedDateTime.now(ZoneId.of("Europe/Paris"))));
		result.append("\n");
		schedules.forEach(stop -> {
			stop.getStopTimes().forEach(stopTime -> {
				int placeForStopHeadSign = 16 - 6 - stopTime.getDeparturesInMins().length();
				if (placeForStopHeadSign < 0) placeForStopHeadSign = 0;
				result
					.append(padStart(stopTime.getIconDisplayText(), 4, ' '))
					.append(" ")
					.append(stopTime.getStopHeadsign().replace('\u00A0',' ').trim().substring(0, placeForStopHeadSign))
					.append(" ")
					.append(stopTime.getDeparturesInMins())
					.append("\n");
			});
		});
		replaceUniCodeChars(result);		
		return result.toString();
	}

	void replaceUniCodeChars(StringBuilder str, char from, char to) {
		for (int index = 0; index < str.length(); index++) {
		    if (str.charAt(index) == from) {
		    	str.setCharAt(index, to);
		    }
		}
	}
	
	private void replaceUniCodeChars(StringBuilder str) {
		replaceUniCodeChars(str, 'á', 'a');
		replaceUniCodeChars(str, 'Á', 'A');
		replaceUniCodeChars(str, 'é', 'e');
		replaceUniCodeChars(str, 'É', 'e');
		replaceUniCodeChars(str, 'í', 'i');
		replaceUniCodeChars(str, 'Í', 'I');
		replaceUniCodeChars(str, 'ó', 'o');
		replaceUniCodeChars(str, 'Ó', 'O');
		replaceUniCodeChars(str, 'ö', 'o');
		replaceUniCodeChars(str, 'Ö', 'O');
		replaceUniCodeChars(str, 'ő', 'o');
		replaceUniCodeChars(str, 'Ő', 'o');
		replaceUniCodeChars(str, 'ú', 'u');
		replaceUniCodeChars(str, 'Ú', 'U');
		replaceUniCodeChars(str, 'ü', 'u');
		replaceUniCodeChars(str, 'Ü', 'U');
		replaceUniCodeChars(str, 'ű', 'u');
		replaceUniCodeChars(str, 'Ű', 'U');
		replaceUniCodeChars(str, (char)160, (char)32);
	}
	
	
}
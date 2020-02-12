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
					.append(stopTime.getIconDisplayText().length() == 2 ? " " : "")
					.append(stopTime.getIconDisplayText())
					.append(" ")
					.append(replaceUniCodeChars(stopTime.getStopHeadsign().substring(0, placeForStopHeadSign)), (char)160, (char)32)
					.append(" ")
					.append(stopTime.getDeparturesInMins())
					.append("\n");		
			});
		});
		replaceUniCodeChars(result);		
		for (int i = 0; i < result.length(); i ++) {
			System.out.print(result.charAt(i));
			System.out.print(" ");
			System.out.println((int)result.charAt(i));
		}
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
		replaceUniCodeChars(str, 'Ó', 'ó');
		replaceUniCodeChars(str, 'ö', 'o');
		replaceUniCodeChars(str, 'Ö', 'O');
		replaceUniCodeChars(str, 'ő', 'o');
		replaceUniCodeChars(str, 'Ő', 'o');
		replaceUniCodeChars(str, 'ü', 'u');
		replaceUniCodeChars(str, 'Ü', 'U');
		replaceUniCodeChars(str, 'ű', 'u');
		replaceUniCodeChars(str, 'Ű', 'U');
		replaceUniCodeChars(str, (char)160, (char)32);
	}
	
	
}
package com.ipuppyp.bkkproxy.delegate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.ipuppyp.bkkproxy.delegate.arrivalsanddeparturesforstop.domain.ArrivalsAndDeparturesForStop;

@Component
public class ArrivalsAndDeparturesForStopApiDelegate {

	private static final String API_URL = "https://futar.bkk.hu/api/query/v1/ws/otp/api/where/arrivals-and-departures-for-stop.json?includeReferences=trips&onlyDepartures=true&limit=100&minutesBefore=0&minutesAfter=100&stopId=";
	
	@Autowired
	private RestTemplate restTemplate;

	public ArrivalsAndDeparturesForStop delegate(String stopId) {
		return restTemplate.getForObject(API_URL + stopId, ArrivalsAndDeparturesForStop.class); // TODO:handle RestClientException
	}
}

package com.ipuppyp.bkkproxy.delegate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.ipuppyp.bkkproxy.delegate.domain.scheduleforstop.ScheduleForStop;

@Component
public class ScheduleForStopBusinessApiDelegate {

	private static final String API_URL = "https://futar.bkk.hu/api/query/v1/ws/otp/api/where/schedule-for-stop.json?includeReferences=false&onlyDepartures=true&stopId=";//TODO:move to config
	
	@Autowired
	private RestTemplate restTemplate;

	public ScheduleForStop delegate(String stopId) {
		return restTemplate.getForObject(API_URL + stopId, ScheduleForStop.class); // TODO:handle RestClientException
	}
}

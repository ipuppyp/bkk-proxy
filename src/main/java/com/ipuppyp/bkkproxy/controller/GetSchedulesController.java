package com.ipuppyp.bkkproxy.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ipuppyp.bkkproxy.domain.Stop;
import com.ipuppyp.bkkproxy.service.ScheduleForStopService;
import com.ipuppyp.bkkproxy.transformer.StopToPlainTextTransformer;

@Controller
public class GetSchedulesController {

	@Autowired
	private ScheduleForStopService scheduleForStopService;
	
	@Autowired
	private StopToPlainTextTransformer stopToPlainTextTransformer; 
	
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "text/plain")
	@ResponseBody
	public String get() {
		Collection<Stop> schedules = scheduleForStopService.findAllSchedules();
		return stopToPlainTextTransformer.transform(schedules);
	}

}

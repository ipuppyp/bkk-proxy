package com.ipuppyp.bkkproxy.web.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ipuppyp.bkkproxy.domain.Stop;
import com.ipuppyp.bkkproxy.service.ArrivalsAndDeparturesForStopService;
import com.ipuppyp.bkkproxy.web.transformer.StopToPlainTextTransformer;

@Controller
public class GetStopTimesController {

	@Autowired
	private ArrivalsAndDeparturesForStopService arrivalsAndDeparturesForStopService;
	
	@Autowired
	private StopToPlainTextTransformer stopToPlainTextTransformer; 
	
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "text/plain")
	@ResponseBody
	public String get() {
		Collection<Stop> stopTimes = arrivalsAndDeparturesForStopService.findAllStops();
		return stopToPlainTextTransformer.transform(stopTimes);
	}

}

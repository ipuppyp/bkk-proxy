package com.ipuppyp.bkkproxy.delegate.arrivalsanddeparturesforstop.domain;
import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ipuppyp.bkkproxy.delegate.domain.arrivalsanddeparturesforstop.ArrivalsAndDeparturesForStop;
import com.ipuppyp.bkkproxy.entity.StopEntity;
import com.ipuppyp.bkkproxy.service.ArrivalsAndDeparturesForStopService;
import com.ipuppyp.bkkproxy.service.transformer.ArrivalsAndDeparturesForStopToStopTransformer;

public class ArrivalsAndDeparturesForStopJsonMappingTest {

	
	@Test
	public void testParsing() throws JsonGenerationException, JsonMappingException, IOException {
		//Given
		ObjectMapper objectMapper = new ObjectMapper();		
		
		
		//When
		ArrivalsAndDeparturesForStop r = objectMapper.readValue(
				getClass().getResourceAsStream("/json-test-data/arrivals-and-departures-for-stop2.json"),				
				ArrivalsAndDeparturesForStop.class);		
		//Then
		
		ArrivalsAndDeparturesForStopToStopTransformer t = new ArrivalsAndDeparturesForStopToStopTransformer();
		t.transform(new StopEntity(), r);
		
		Assertions.assertEquals(2, r.getVersion());

		
	}
	
}

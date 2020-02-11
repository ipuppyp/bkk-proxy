package com.ipuppyp.bkkproxy.delegate.arrivalsanddeparturesforstop.domain;
import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ArrivalsAndDeparturesForStopJsonMappingTest {

	
	@Test
	public void testParsing() throws JsonGenerationException, JsonMappingException, IOException {
		//Given
		ObjectMapper objectMapper = new ObjectMapper();
		
		//When
		ArrivalsAndDeparturesForStop r = objectMapper.readValue(
				getClass().getResourceAsStream("/json-test-data/arrivals-and-departures-for-stop.json"),				
				ArrivalsAndDeparturesForStop.class);		
		//Then
		Assertions.assertEquals(2, r.getVersion());

		
	}
	
}

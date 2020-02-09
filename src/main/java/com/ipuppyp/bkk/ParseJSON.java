package com.ipuppyp.bkk;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ipuppyp.bkk.delegate.scheduleforstop.domain.ScheduleForStop;

public class ParseJSON {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		// TODO Auto-generated method stub
		ObjectMapper mapper = new ObjectMapper();
		
		ScheduleForStop readValue = mapper.readValue(ParseJSON.class.getResourceAsStream("/data-example/schedule-for-stop-response2.json"), ScheduleForStop.class);
		System.out.println(readValue.getData());
		System.out.println("hi");
	}

}

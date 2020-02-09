package com.ipuppyp.bkk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.ipuppyp.bkk.entity.StopEntity;
import com.ipuppyp.bkk.repository.StopRepository;
import com.ipuppyp.bkk.service.ScheduleForStopService;

@SpringBootApplication
public class BkkApplication {

	 
//	@Autowired
//	private StopRepository stopRepository;
	
	@Autowired
	ScheduleForStopService scheduleForStopService; 
	
	public static void main(String[] args) {
		SpringApplication.run(BkkApplication.class, args);
		
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			
			System.out.println(scheduleForStopService.findAllSchedules());
			

//			StopEntity stop = new StopEntity();
//			stop.setStopId("BKK_F02784");
//			stop.setName("Fischer István utca");
//			stopRepository.save(stop);

		};
	}

}

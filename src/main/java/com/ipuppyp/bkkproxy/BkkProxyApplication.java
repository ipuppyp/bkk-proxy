package com.ipuppyp.bkkproxy;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.ipuppyp.bkkproxy.domain.Stop;
import com.ipuppyp.bkkproxy.entity.StopEntity;
import com.ipuppyp.bkkproxy.repository.StopRepository;
import com.ipuppyp.bkkproxy.service.ScheduleForStopService;

@SpringBootApplication
public class BkkProxyApplication {

	 
	@Autowired
	private StopRepository stopRepository;
	
	@Autowired
	ScheduleForStopService scheduleForStopService; 
	
	public static void main(String[] args) {
		SpringApplication.run(BkkProxyApplication.class, args);
		
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			
			StopEntity stop = new StopEntity();
			stop.setStopId("BKK_F02784");
			stop.setName("Fischer István utca");
			stop.setEnabled(Boolean.TRUE);
			stopRepository.save(stop);

//			Collection<Stop> findAllSchedules = scheduleForStopService.findAllSchedules();
//			System.out.println(findAllSchedules);
//			
//			System.exit(-1);


		};
	}

}

package com.ipuppyp.bkkproxy;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.ipuppyp.bkkproxy.entity.StopEntity;
import com.ipuppyp.bkkproxy.repository.StopRepository;

@SpringBootApplication
public class BkkProxyApplication extends SpringBootServletInitializer {

	 
	@Autowired
	private StopRepository stopRepository;
	
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

		};
	}
	
	@Bean
	public RestTemplate restTemplate() {
		HttpClient httpClient = HttpClients.custom()
                .setSSLHostnameVerifier(new NoopHostnameVerifier())
                .build();
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setHttpClient(httpClient);
		return new RestTemplate(requestFactory);
	}
	

}

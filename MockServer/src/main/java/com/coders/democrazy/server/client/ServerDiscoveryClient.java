package com.coders.democrazy.server.client;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.coders.democrazy.server.model.Greeting;

@Component
public class ServerDiscoveryClient {

	private static final Logger LOGGER = LoggerFactory.getLogger(ServerDiscoveryClient.class);
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	public ResponseEntity<Greeting> getDiscoveryGreeting(String type, String name) {
		RestTemplate restTemplate = new RestTemplate();
		
		try {
			List<ServiceInstance> instances = discoveryClient.getInstances("client");
			
			if (instances.size() == 0) {
				LOGGER.error("Cannot find any instance");
				return new ResponseEntity<Greeting>(HttpStatus.NOT_FOUND);
			}
			
			String serverUri = String.format("%s/greeting/%s/%s", instances.get(0).getUri().toString(), type, name);
			
			ResponseEntity<Greeting> restExchange = restTemplate.exchange(serverUri, HttpMethod.GET, null, Greeting.class, type, name);
			
			return restExchange;
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}

package com.coders.democrazy.server.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.coders.democrazy.server.model.Greeting;

@Component
public class ServerRestClient {

	private static final Logger LOGGER = LoggerFactory.getLogger(ServerRestClient.class);
	
	@Autowired
	RestTemplate restTemplate;
	
	public ResponseEntity<Greeting> getRestGreeting(String type, String name) {
		return restTemplate.exchange("http://localhost:8085/greeting/{type}/{name}", HttpMethod.GET, 
				null, Greeting.class, type, name);
	}
}
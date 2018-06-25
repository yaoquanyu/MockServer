package com.coders.democrazy.server.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.coders.democrazy.server.model.Greeting;

@Component
public class ServerRestClient {
	
	@Autowired
	RestTemplate restTemplate;
	
	public ResponseEntity<Greeting> getRestGreeting(String type, String name) {
		return restTemplate.exchange("http://client:8085/greeting/{type}/{name}", HttpMethod.GET,
				null, Greeting.class, type, name);
	}
}

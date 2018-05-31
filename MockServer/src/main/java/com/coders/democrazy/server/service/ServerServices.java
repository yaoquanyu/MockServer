package com.coders.democrazy.server.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.coders.democrazy.server.client.ServerDiscoveryClient;
import com.coders.democrazy.server.client.ServerFeignClient;
import com.coders.democrazy.server.client.ServerRestClient;
import com.coders.democrazy.server.model.Greeting;

@Service
public class ServerServices {

	@Autowired
	ServerDiscoveryClient discoveryClient;
	
	@Autowired
	ServerFeignClient feignClient;
	
	@Autowired
	ServerRestClient restClient;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ServerServices.class);
	
	public ResponseEntity<Greeting> greetingToClient(String type, String name) {
		ResponseEntity<Greeting> reponse = null;
		
		switch (type) {
			case "discovery":
				reponse = discoveryClient.getDiscoveryGreeting(type, name);
				break;
			case "feign":
				reponse = feignClient.getFeignGreeting(type, name);
				break;
			case "rest":
				reponse = restClient.getRestGreeting(type, name);
				break;
			default:
				break;
		}
		return reponse;
	}
}

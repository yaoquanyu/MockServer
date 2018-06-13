package com.coders.democrazy.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.coders.democrazy.server.client.ServerDiscoveryClient;
import com.coders.democrazy.server.client.ServerFeignClient;
import com.coders.democrazy.server.client.ServerRestClient;
import com.coders.democrazy.server.model.Greeting;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ServerServices {

	@Autowired
	ServerDiscoveryClient discoveryClient;
	
	@Autowired
	ServerFeignClient feignClient;
	
	@Autowired
	ServerRestClient restClient;
	
	public ResponseEntity<Greeting> greetingToClient(String type, String name) {
		ResponseEntity<Greeting> response = null;
		
		switch (type) {
			case "discovery":
				response = discoveryClient.getDiscoveryGreeting(type, name);
				log.info("Got discover client response.");
				break;
			case "feign":
				response = feignClient.getFeignGreeting(type, name);
				log.info("Got feign client response");
				break;
			case "rest":
				response = restClient.getRestGreeting(type, name);
				log.info("Got rest client response");
				break;
			default:
				break;
		}
		return response;
	}
}

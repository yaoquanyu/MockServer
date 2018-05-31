package com.coders.democrazy.server.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coders.democrazy.server.model.Greeting;
import com.coders.democrazy.server.service.ServerServices;

@RestController
public class GreetingController {

	@Autowired
	private ServerServices services;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(GreetingController.class);
	
	@RequestMapping("/greeting/{type}/{name}")
	public ResponseEntity<Greeting> greeting(@PathVariable(value = "type") String type,
			@PathVariable(value = "name") String name) {
		LOGGER.info("Server got greeting from: {} with type: {}", name, type);
		return services.greetingToClient(type, name);
	}
}

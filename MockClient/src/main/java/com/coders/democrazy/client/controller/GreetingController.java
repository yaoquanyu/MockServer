package com.coders.democrazy.client.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coders.democrazy.client.model.Greeting;

@RestController
public class GreetingController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(GreetingController.class);
	
	@RequestMapping("/greeting/{type}/{name}")
	public Greeting greeting(@PathVariable(value = "type") String type,
			@PathVariable(value = "name") String name) {
		LOGGER.info("Client got greeting from: {} with type: {}", name, type);
		return new Greeting(name);
	}
}

package com.coders.democrazy.client.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coders.democrazy.client.model.Greeting;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class GreetingController {
	
	@RequestMapping("/greeting/{type}/{name}")
	public Greeting greeting(@PathVariable(value = "type") String type,
			@PathVariable(value = "name") String name) {
		log.info("Client got greeting from: {} with type: {}", name, type);
		return new Greeting(name);
	}
}

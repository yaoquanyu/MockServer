package com.coders.democrazy.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coders.democrazy.server.model.Greeting;
import com.coders.democrazy.server.service.ServerServices;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class GreetingController {

	@Autowired
	private ServerServices services;
	
	@RequestMapping("/greeting/{type}/{name}")
	public ResponseEntity<Greeting> greeting(@PathVariable(value = "type") String type,
			@PathVariable(value = "name") String name) {
		log.info("Server got greeting from: {} with type: {}", name, type);
		return services.greetingToClient(type, name);
	}
}

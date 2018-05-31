package com.coders.democrazy.server.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.coders.democrazy.server.model.Greeting;

@FeignClient("client")
public interface ServerFeignClient {

	@RequestMapping(
			method = RequestMethod.GET,
			value = "/greeting/{type}/{name}",
			consumes = "application/json")
	ResponseEntity<Greeting> getFeignGreeting(@PathVariable(value = "type") String type,
			@PathVariable(value = "name") String name);
}

package com.trace.application.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Microservice1Controller {

	private final Logger LOG = LoggerFactory.getLogger(Microservice1Controller.class);

	@Autowired
	RestTemplate restTemplate;

	@Value("${spring.applicaion.baseUrl}")
	private String baseUrl;

	@GetMapping(value = "/microservice1")
	public String getMessage1() {
		LOG.info("Inside getMessage1");
		String response = (String) restTemplate.exchange(baseUrl, HttpMethod.GET, null, String.class).getBody();
		LOG.info("The response recieved by method2 is " + response);
		return response;
	}

}

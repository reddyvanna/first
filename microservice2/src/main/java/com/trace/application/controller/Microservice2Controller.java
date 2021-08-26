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
public class Microservice2Controller {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Value("${spring.applicaion.baseUrl}")
	private String baseUrl;

	@Autowired
	RestTemplate restTemplate;

	@GetMapping(value = "/microservice2")
	public String method2() {
		LOG.info("Inside method2");
		String baseUrl = "http://localhost:8082/microservice3";
		String response = (String) restTemplate.exchange(baseUrl, HttpMethod.GET, null, String.class).getBody();
		LOG.info("The response recieved by method2 is " + response);
		return response;
	}

}

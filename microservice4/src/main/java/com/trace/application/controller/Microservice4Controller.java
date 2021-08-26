package com.trace.application.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Microservice4Controller {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@GetMapping(value = "/microservice4")
	public String method4() {
		LOG.info("Inside method4");
		return "Hello World!";
	}

}

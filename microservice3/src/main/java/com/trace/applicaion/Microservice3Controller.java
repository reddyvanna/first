package com.trace.applicaion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Microservice3Controller {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	RestTemplate restTemplate;

	@Value("${spring.applicaion.baseUrl}")
	private String baseUrl;

	@GetMapping(value = "/microservice3")
	public String method3() {
		LOG.info("Inside method3");
		String baseUrl = "http://localhost:8083/microservice4";
		try {
			Thread.sleep(1000);
		} catch (Exception ex) {

		}
		String response = (String) restTemplate.exchange(baseUrl, HttpMethod.GET, null, String.class).getBody();
		LOG.info("The response recieved by method3 is " + response);
		return response;
	}

}

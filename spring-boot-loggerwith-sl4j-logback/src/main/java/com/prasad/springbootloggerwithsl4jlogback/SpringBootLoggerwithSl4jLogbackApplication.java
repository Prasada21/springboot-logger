package com.prasad.springbootloggerwithsl4jlogback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootLoggerwithSl4jLogbackApplication {
	
	
	Logger log = LoggerFactory.getLogger(SpringBootLoggerwithSl4jLogbackApplication.class);

	@GetMapping("/test/{name}")
	public String greeting(@PathVariable String name) {
		log.debug("Request {}", name);
		if (name.equalsIgnoreCase("test")) {
			throw new RuntimeException("Opps Exception raised....");
		}
		String response = "Hi " + name + " Welcome to Java Techie";
		log.debug("Response {}", response);
		return response;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLoggerwithSl4jLogbackApplication.class, args);
	}

}

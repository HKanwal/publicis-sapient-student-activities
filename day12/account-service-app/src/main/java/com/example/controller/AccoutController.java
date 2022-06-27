package com.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccoutController {

	// Get port. @Value() gets application.properties props
	// Multiple MS instances can be run on different machines/ports
	// by specifying the port when executing the .jar.
	@Value("${server.port}")
	private String port;

	@GetMapping
	public String greet() {
		System.out.println("Received get request.");
		return "Hello! this is Account Microservice running on port: "+this.port;
	}
}

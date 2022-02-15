package com.legato.paymentservice.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
	
	@GetMapping("/greet")
	public ResponseEntity<Object> greetings() {
		return ResponseEntity.status(200).body("Hello Microservices World!");
	}
	
	
	
	
	
}

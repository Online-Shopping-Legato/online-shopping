package com.legato.paymentservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("firstapp")
public class Controller {
	
	@GetMapping("/greet")
	public ResponseEntity<Object> greetings() {
		return ResponseEntity.status(200).body("Hello Microservices World!");
	}
	
}

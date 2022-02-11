package com.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.beans.Customer;
import com.customer.service.CustomerService;

@RestController
@RequestMapping("/ca")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping(path = "/customer", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> fetchAll() {

		ResponseEntity<Object> response = null;
		List<Customer> listUsers = customerService.getAll();
		response = ResponseEntity.status(HttpStatus.OK).body(listUsers);
		return response;
	}

	@PostMapping(path = "/customer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> saveUser(@RequestBody Customer customer) {

		ResponseEntity<Object> response = null;
		// System.out.println(customer.getA);
		Customer createdCustomer = customerService.saveCustomer(customer);
		response = ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
		return response;
	}

	@GetMapping(path = "/customer/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> findUser(@PathVariable("id") String id) {
		ResponseEntity<Object> response = null;
		try {
			Customer u = customerService.getByOne(Long.parseLong(id));
			response = ResponseEntity.status(HttpStatus.OK).body(u);
		} catch (Exception e) {
			// msg = new CustomMessage(e.getMessage(), 400);
			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
		}
		return response;
	}
}

package com.legato.paymentservice.service;

import java.util.List;

import com.legato.paymentservice.beans.Customer;

public interface CustomerService {

	public List<Customer> getAll();
	
	public Customer saveCustomer(Customer c);
	
	public Customer getByOne(Long id);

	public Customer getCustomerById(Long customerId);

	public String getCustomerpassword(Long customerId);

}
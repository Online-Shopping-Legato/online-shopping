package com.customer.service;

import java.util.List;

import com.customer.beans.Customer;

public interface CustomerService {

	public List<Customer> getAll();
	
	public Customer saveCustomer(Customer c);
	
	public Customer getByOne(Long id);

}

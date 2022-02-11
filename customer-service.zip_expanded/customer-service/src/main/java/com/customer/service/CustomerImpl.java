package com.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.beans.Customer;
import com.customer.dao.CustomerDao;

@Service
public class CustomerImpl implements CustomerService {

	@Autowired
	private CustomerDao custmoreDao;

	@Override
	public List<Customer> getAll() {
		return custmoreDao.findAll();
	}

	@Override
	public Customer saveCustomer(Customer c) {
		return custmoreDao.save(c);
	}

	@Override
	public Customer getByOne(Long id) {
		return custmoreDao.findById(id).orElse(null);
	}

}

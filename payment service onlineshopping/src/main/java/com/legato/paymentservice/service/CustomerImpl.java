package com.legato.paymentservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.legato.paymentservice.dao.CustomerDao;
import com.legato.paymentservice.beans.Customer;

@Service
public class CustomerImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;

	@Override
	public List<Customer> getAll() {
		return customerDao.findAll();
	}

	@Override
	public Customer saveCustomer(Customer c) {
		Customer s = null;
		if (c != null) {
			if (!(c.getCustomername().equals(""))) {
				s = customerDao.save(c);
			}
		}
		return s;
	}

	@Override
	public Customer getByOne(Long id) {
		return customerDao.findById(id).orElse(null);
	}

	@Override
	public Customer getCustomerById(Long customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCustomerpassword(Long customerId) {
		// TODO Auto-generated method stub
		return null;
	}

}

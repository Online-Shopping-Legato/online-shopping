package com.customer.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.beans.Customer;

public interface CustomerDao extends JpaRepository<Customer, Long> {

//	@Query("SELECT c.customerid, c.customername, a.addressid, a.streetname,a.city "
//			+ "FROM Customer c INNER JOIN Address a ON c.customerid = a.customerid")
//	public List<CustomerDTO> getAllDetails();
}

package com.legato.paymentservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.legato.paymentservice.beans.ProductsCustomers;

public interface ProductsCustomerDao extends JpaRepository<ProductsCustomers, Long>{

}

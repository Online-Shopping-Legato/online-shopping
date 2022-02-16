package com.legato.paymentservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.legato.paymentservice.beans.Product;

public interface ProductDao extends JpaRepository<Product, Long> {

}
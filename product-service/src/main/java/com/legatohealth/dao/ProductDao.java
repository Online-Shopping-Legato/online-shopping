package com.legatohealth.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.legatohealth.bean.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {

}

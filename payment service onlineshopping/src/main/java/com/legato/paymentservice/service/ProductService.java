package com.legato.paymentservice.service;

import java.util.List;

import com.legato.paymentservice.beans.Product;

public interface ProductService {
	
	public List<Product> fetchProducts(int itemId);
	
	public Product getCustomerById(Long id);
	

}
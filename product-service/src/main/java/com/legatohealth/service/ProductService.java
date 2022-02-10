package com.legatohealth.service;

import java.util.List;

import com.legatohealth.bean.Product;

public interface ProductService {
	
	public List<Product> fetchProducts(int itemId);
	
	

}

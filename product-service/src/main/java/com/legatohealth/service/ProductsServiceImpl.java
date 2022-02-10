package com.legatohealth.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.legatohealth.bean.Product;
import com.legatohealth.dao.ProductDao;

@Service
public class ProductsServiceImpl implements ProductService {

	@Autowired
	private ProductDao dao;

	@Override
	public List<Product> fetchProducts(int itemId) {
		List<Product> productList = fetchAll();

		return productList.stream().filter(curobj -> curobj.getItemId() == itemId).collect(Collectors.toList());

	}

	public List<Product> fetchAll() {
		return dao.findAll();
	}

}

package com.legato.paymentservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.legato.paymentservice.beans.Product;
import com.legato.paymentservice.dao.ProductDao;

@Service
public class ProductsServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Override
	public List<Product> fetchProducts(int itemId) {
		List<Product> productList = fetchAll();

		return productList.stream().filter(curobj -> curobj.getItemId() == itemId).collect(Collectors.toList());

	}

	public List<Product> fetchAll() {
		return productDao.findAll();
	}

	@Override
	public Product getCustomerById(Long id) {
		// TODO Auto-generated method stub
		return productDao.getOne(id);
	}

}
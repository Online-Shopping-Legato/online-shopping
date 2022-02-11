package com.legatohealth.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.legatohealth.bean.Item;
import com.legatohealth.bean.Product;
import com.legatohealth.service.ItemService;
import com.legatohealth.service.ProductService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("product-service")
public class ProductController {

	@Autowired
	private ItemService itemService;

	@Autowired
	private ProductService productService;

	@GetMapping(path = "/fetchAll")
	public ResponseEntity<Object> fetchAllItems() {
		List<Item> itemList = itemService.fetchAllItems();
		return ResponseEntity.status(HttpStatus.OK).body(itemList);
	}

	@GetMapping(path = "/fetchById/{itemId}")
	public ResponseEntity<Object> fecthProductDetails(@PathVariable int itemId) {

		List<Product> productList = productService.fetchProducts(itemId);

		List<Product> sortedList = productList.stream().filter(curobj -> curobj.getItemId() == itemId)
				.collect(Collectors.toList());

		return ResponseEntity.status(HttpStatus.OK).body(sortedList);
	}

}

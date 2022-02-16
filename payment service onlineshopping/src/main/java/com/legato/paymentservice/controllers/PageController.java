package com.legato.paymentservice.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.legato.paymentservice.beans.CreditCard;
import com.legato.paymentservice.beans.Customer;
import com.legato.paymentservice.beans.PaymentDTO;
import com.legato.paymentservice.beans.ProcessPaymentDTO;
import com.legato.paymentservice.beans.Product;
import com.legato.paymentservice.beans.ProductsCustomers;
import com.legato.paymentservice.client.CreditCardClient;
import com.legato.paymentservice.client.CustomerClient;
import com.legato.paymentservice.service.CustomerService;
import com.legato.paymentservice.service.ItemService;
import com.legato.paymentservice.service.ProductService;

@Controller
public class PageController {

	@Autowired
	private CustomerClient customerClient;
	
	@Autowired
	private CreditCardClient creditCardClient;
	
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ItemService itemService;

	@Autowired
	private ProductService productService;
	
	@PostMapping("/payment")
	public String payment(Model model, PaymentDTO paymentDTO) {
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("payment");
		model.addAttribute("amount", paymentDTO.getAmount());
		model.addAttribute("customerId", paymentDTO.getCustomerId());
		model.addAttribute("productList", paymentDTO.getProductList());
		return "payment";
	}
	
	
	
	private List<Product> convertStringToList(List<String> list) {
		List<Product> products = new ArrayList<>();
		ObjectMapper mapper = new ObjectMapper();
		for (int i = 0; i < list.size(); i++) {
			try {
	        	String productStr = list.get(i);
	            Product product = mapper.readValue(productStr, Product.class);

	            System.out.println("artist.getId() = " + product.getItemId());
	            System.out.println("artist.getName() = " + product.getProductName());
	            products.add(product);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}
		return products;
	}
}

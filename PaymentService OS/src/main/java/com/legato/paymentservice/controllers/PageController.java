package com.legato.paymentservice.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.legato.paymentservice.beans.CreditCard;
import com.legato.paymentservice.beans.Customer;
import com.legato.paymentservice.beans.ProcessPaymentDTO;
import com.legato.paymentservice.beans.Product;
import com.legato.paymentservice.beans.ProductsCustomers;
import com.legato.paymentservice.client.CreditCardClient;
import com.legato.paymentservice.client.CustomerClient;

@Controller
public class PageController {

	@Autowired
	private CustomerClient customerClient;
	
	@Autowired
	private CreditCardClient creditCardClient;
	
	@PostMapping("/payment")
	public ModelAndView payment() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("payment");
		return mav;
	}
	
	@GetMapping("/processPayment")
	public ModelAndView processPayment(ProcessPaymentDTO processPaymentDTO) {
		
		ModelAndView mav = new ModelAndView();
		if(processPaymentDTO.getPaymentType() == "netbanking") {
			
			Customer customer = customerClient.getCustomerById(processPaymentDTO.getCustomerId());
			if(customer != null && (customer.getPassword() == processPaymentDTO.getPassword())) {
				CreditCard creditCardInfo = creditCardClient.getCCById(customer.getCustomerId());
				float customerBal = creditCardInfo.getAmount();
				float amount = processPaymentDTO.getAmount();
				if(customerBal > amount) {
					
					customerBal -= amount;
					creditCardInfo.setAmount(customerBal);
					ResponseEntity<String> entity = creditCardClient.updateCC(creditCardInfo);
					String body = entity.getBody();
					
					MediaType contentType = entity.getHeaders().getContentType();
					HttpStatus statusCode = entity.getStatusCode();
					if(statusCode.is2xxSuccessful()) {
						
						List<ProductsCustomers> productCustomersList = new ArrayList<>();
						List<Product> productList = processPaymentDTO.getProductlist();
						for(Product product : productList) {
							
							ProductsCustomers productsCustomers = new ProductsCustomers();
							productsCustomers.setCreditCardNumber(creditCardInfo.getCreditCardNumber());
							productsCustomers.setCustomerId(customer.getCustomerId());
							productsCustomers.setProductId(product.getProductId());
							productsCustomers.setPrice(product.getPrice());
							productsCustomers.setDebitCardNumber(customer.getDebitCardNumber());
						}
						// Call the CRUD service to save the data
						mav.addObject("message", "Order Placed");
						mav.setViewName("success");
						return mav;
					}
					
				}	
			}
			
		}
		
		
		mav.addObject("amount", processPaymentDTO.getAmount());
		mav.addObject("productList", processPaymentDTO.getProductlist());
		mav.addObject("customerId", processPaymentDTO.getCustomerId());
		mav.setViewName("payment");
		return mav;
	}
}

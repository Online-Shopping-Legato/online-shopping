package com.legato.paymentservice.controllers;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.legato.paymentservice.beans.CreditCard;
import com.legato.paymentservice.beans.Customer;
import com.legato.paymentservice.beans.Item;
import com.legato.paymentservice.beans.ProcessPaymentDTO;
import com.legato.paymentservice.beans.Product;
import com.legato.paymentservice.beans.ProductsCustomers;
import com.legato.paymentservice.service.CreditCardService;
import com.legato.paymentservice.service.CustomerService;
import com.legato.paymentservice.service.ItemService;
import com.legato.paymentservice.service.ProductService;
import com.legato.paymentservice.dao.ProductsCustomerDao;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api")
public class ApiController {
	
	@Autowired
	private CustomerService customerService;

	@Autowired
	private ProductService productService;
	
	@Autowired
	CreditCardService creditService;
	
	@Autowired 
	private ProductsCustomerDao productsCustomerDao;
	
	@GetMapping("/greet")
	public ResponseEntity<Object> greetings() {
		return ResponseEntity.status(200).body("Hello Microservices World!");
	}
	
	@PostMapping(value="/processPayment",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> processPayment( @RequestBody ProcessPaymentDTO processPaymentDTO) {
		System.out.println(processPaymentDTO);
		if(processPaymentDTO.getPaymentType().equalsIgnoreCase("netbanking")) {	
			Customer customer = customerService.getByOne(processPaymentDTO.getCustomerId());
			System.out.println(customer +" customer data");
			if(customer != null && (customer.getCustomerpassword().equalsIgnoreCase( processPaymentDTO.getPassword()))) {
				CreditCard creditCardInfo = creditService.findCreditCardByCustomerId(customer.getCustomerid());
				double customerBal = creditCardInfo.getAmount().doubleValue();
				double amount = processPaymentDTO.getAmount().floatValue();
				if(customerBal > amount) {
					customerBal -= amount;
					creditCardInfo.setAmount(new BigDecimal(customerBal));
					CreditCard creditCard = creditService.update(creditCardInfo);
					List<ProductsCustomers> productCustomersList = new ArrayList<>();
					List<Product> productList = convertStringToList(processPaymentDTO.getProductlist());
					for(Product product : productList) {
						ProductsCustomers productsCustomers = new ProductsCustomers();
						productsCustomers.setCreditCardNumber(creditCardInfo.getCreditCardNumber());
						productsCustomers.setCustomerId(customer.getCustomerid());
						productsCustomers.setProductId(product.getProductId());
						productsCustomers.setPrice(product.getPrice());
						productsCustomers.setDebitCardNumber(customer.getDebitcardnumber());
					}
//					
					productsCustomerDao.saveAll(productCustomersList);
//						// Call the CRUD service to save the data
						return ResponseEntity.ok(productCustomersList);
					}
					
				}	
			}
			return ResponseEntity.status(200).body("Authentication Failed");  //body("Authentication Fail
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
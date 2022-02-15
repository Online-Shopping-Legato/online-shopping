package com.legato.paymentservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.legato.paymentservice.beans.Product;

@FeignClient(value="product-service", url="<placeholder-url>")
public interface ProductClient {
	
	@RequestMapping(method = RequestMethod.GET, value = "/product/id}", produces = "application/json")
	Product getProductById(@PathVariable("productId") Long productId);

}

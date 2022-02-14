package com.legato.paymentservice.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.legato.paymentservice.beans.Customer;

@FeignClient(value="customer-service", url="<placeholder-url>")
public interface CustomerClient {
	
	@RequestMapping(method = RequestMethod.GET, value = "/customers/id}", produces = "application/json")
    Customer getCustomerById(@PathVariable("customerId") Long customerId);
	

}

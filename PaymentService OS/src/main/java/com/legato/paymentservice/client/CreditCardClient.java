package com.legato.paymentservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.legato.paymentservice.beans.CreditCard;

@FeignClient(value="credit-card-service", url="<placeholder-url>")
public interface CreditCardClient {

	@RequestMapping(method = RequestMethod.GET, value = "/creditcard/id}", produces = "application/json")
	CreditCard getCCById(@PathVariable("ccNumber") Long ccNumber);
	
	@RequestMapping(method = RequestMethod.POST, value = "/save}", produces = "application/json")
	ResponseEntity<String> updateCC(@RequestBody CreditCard cc);
	
}
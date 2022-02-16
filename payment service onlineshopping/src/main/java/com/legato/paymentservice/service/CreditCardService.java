package com.legato.paymentservice.service;

import com.legato.paymentservice.beans.CreditCard;

public interface CreditCardService {
	
	public CreditCard findCreditCardByCreditCardNumber(Long creditCardNumber);
	
	public CreditCard findCreditCardByCustomerId(Long customerId);
	
	public CreditCard update(CreditCard creditCard);

}
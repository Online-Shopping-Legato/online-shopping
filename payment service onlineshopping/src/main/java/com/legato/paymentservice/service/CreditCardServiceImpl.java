package com.legato.paymentservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.legato.paymentservice.beans.CreditCard;
import com.legato.paymentservice.dao.CreditCardDao;

@Service
public class CreditCardServiceImpl implements CreditCardService{
	
	@Autowired
	private CreditCardDao creditCardDao;
	
	@Override
	public CreditCard findCreditCardByCreditCardNumber(Long creditCardNumber) {
		// TODO Auto-generated method stub
		return creditCardDao.getOne(creditCardNumber);
	}

	@Override
	public CreditCard findCreditCardByCustomerId(Long customerId) {
		// TODO Auto-generated method stub
		return creditCardDao.findByCustomerId(customerId);
	}
	
	@Override
	public CreditCard update(CreditCard creditCard) {
		return creditCardDao.save(creditCard);
	}

}
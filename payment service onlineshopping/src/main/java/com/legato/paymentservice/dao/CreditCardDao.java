package com.legato.paymentservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.legato.paymentservice.beans.CreditCard;
import com.legato.paymentservice.beans.Customer;

public interface CreditCardDao extends JpaRepository<CreditCard, Long> {

	CreditCard findByCustomerId(Long customerId);

}

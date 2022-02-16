package com.legato.paymentservice.beans;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ProductsCustomers {
	@Id
	@GeneratedValue
	private Long id;
	private Long customerId;
	private Long productId;
	private Long creditCardNumber;
	private Long  debitCardNumber;
	private BigDecimal price;
	
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Long getCreditCardNumber() {
		return creditCardNumber;
	}
	public void setCreditCardNumber(Long creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	public Long getDebitCardNumber() {
		return debitCardNumber;
	}
	public void setDebitCardNumber(Long debitCardNumber) {
		this.debitCardNumber = debitCardNumber;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	
}


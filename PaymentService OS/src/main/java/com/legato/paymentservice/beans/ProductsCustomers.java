package com.legato.paymentservice.beans;


public class ProductsCustomers {
	private Long customerId;
	private Long productId;
	private Long creditCardNumber;
	private Long  debitCardNumber;
	private float price;
	
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
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	
}


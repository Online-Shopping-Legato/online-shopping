package com.legato.paymentservice.beans;

public class Customer {

	private Long customerId;
	private Long accountNumber;
	private String customerName;
	private String password;
	private Long debitCardNumber;
	private float amount;
	
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getDebitCardNumber() {
		return debitCardNumber;
	}
	public void setDebitCardNumber(Long debitCardNumber) {
		this.debitCardNumber = debitCardNumber;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	
}

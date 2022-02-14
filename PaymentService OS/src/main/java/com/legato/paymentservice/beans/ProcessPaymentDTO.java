package com.legato.paymentservice.beans;

import java.util.List;

public class ProcessPaymentDTO {
	private Long customerId;
	private Float amount;
	private String paymentType;
	private List<Product> productlist;
	private Long ccNumber;
	private Long dcNumber;
	private String password;
	
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public List<Product> getProductlist() {
		return productlist;
	}
	public void setProductlist(List<Product> productlist) {
		this.productlist = productlist;
	}
	public Long getCcNumber() {
		return ccNumber;
	}
	public void setCcNumber(Long ccNumber) {
		this.ccNumber = ccNumber;
	}
	public Long getDcNumber() {
		return dcNumber;
	}
	public void setDcNumber(Long dcNumber) {
		this.dcNumber = dcNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}

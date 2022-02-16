package com.legato.paymentservice.beans;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@Column(name = "customerid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerid;
	private String customername;
	
	@Column(name = "password")
	private String customerpassword;
	private Long accountnumber;
	private Long debitcardnumber;

	//@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	//@JsonManagedReference
	//private Address address;

	public Long getCustomerid() {
		return customerid;
	}

//	public void setCustomerId(Long customerId) {
//		this.customerId = customerId;
//	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getCustomerpassword() {
		return customerpassword;
	}

	public void setCustomerpassword(String customerpassword) {
		this.customerpassword = customerpassword;
	}

	public Long getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(Long accountnumber) {
		this.accountnumber = accountnumber;
	}

	public Long getDebitcardnumber() {
		return debitcardnumber;
	}

	public void setDebitcardnumber(Long debitcardnumber) {
		this.debitcardnumber = debitcardnumber;
	}

/**	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}**/

	@Override
	public String toString() {
		return "Customer [customerid=" + customerid + ", customername=" + customername + ", customerpassword="
				+ customerpassword + ", accountnumber=" + accountnumber + ", debitcardnumber=" + debitcardnumber
				+ ", address="  + "]";
	}

}
package com.legato.paymentservice.beans;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "address")
public class Address {

	@Id
	@Column(name = "addressid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer addressid;
	private String streetname;
	private String city;
	private String state;
	private Long pin;

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "customerid", nullable = false)
	@JsonBackReference
	private Customer customer;

	public Integer getAddressid() {
		return addressid;
	}

	public void setAddressid(Integer addressid) {
		this.addressid = addressid;
	}

	public String getStreetname() {
		return streetname;
	}

	public void setStreetname(String streetname) {
		this.streetname = streetname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getPin() {
		return pin;
	}

	public void setPin(Long pin) {
		this.pin = pin;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Address [addressid=" + addressid + ", streetname=" + streetname + ", city=" + city + ", state=" + state
				+ ", pin=" + pin + ", customer=" + customer + "]";
	}

}
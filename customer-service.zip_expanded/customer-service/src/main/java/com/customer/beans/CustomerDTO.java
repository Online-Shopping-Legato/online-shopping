package com.customer.beans;

public class CustomerDTO {

	private Long customerid;
	private String customername;
//	private String customerpassword;
//	private Long accountnumber;

	private Integer addressid;
	private String streetname;
	private String city;

//	private String state;
//	private Long pin;
	public Long getCustomerid() {
		return customerid;
	}

	public void setCustomerid(Long customerid) {
		this.customerid = customerid;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

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

	@Override
	public String toString() {
		return "CustomerDTO [customerid=" + customerid + ", customername=" + customername + ", addressid=" + addressid
				+ ", streetname=" + streetname + ", city=" + city + "]";
	}

}

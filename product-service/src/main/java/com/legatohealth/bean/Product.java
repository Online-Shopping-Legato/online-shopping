package com.legatohealth.bean;

public class Product {
	
	private int productId;
	private String productName;
	private int itemId;
	private double price;
	
	public Product() {
		super();
	}

	public Product(int productId, String productName, int itemId, double price) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.itemId = itemId;
		this.price = price;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", itemId=" + itemId + ", price="
				+ price + "]";
	}
	
	
	

}

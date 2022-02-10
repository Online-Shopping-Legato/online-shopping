package com.legatohealth.bean;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@Column(name = "productid")
	private int productId;

	@Column(name = "productname")
	private String productName;

	@Column(name = "itemid")
	private int itemId;

	private BigDecimal price;

	public Product() {
		super();
	}

	public Product(int productId, String productName, int itemId, BigDecimal price) {
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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", itemId=" + itemId + ", price="
				+ price + "]";
	}

}

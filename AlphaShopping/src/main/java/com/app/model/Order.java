package com.app.model;

public class Order {
	private int orderid;
	private String email;
	private int productId;
	private String productName;
	private int quantity;
	private String status;
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Order(int orderid, String email, int productId, String productName, int quantity, String status) {
		super();
		this.orderid = orderid;
		this.email = email;
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.status = status;
	}
	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", email=" + email + ", productId=" + productId + ", productName="
				+ productName + ", quantity=" + quantity + ", status=" + status + "]";
	}
	

}

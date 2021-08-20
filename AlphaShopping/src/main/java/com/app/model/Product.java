package com.app.model;

public class Product {

	 private int productId;
	 private String productName;
	 private String productCompany;
	 private String producCategory;
	 private double productPrice;
	 
	 public Product() {
		 
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
	public String getProductCompany() {
		return productCompany;
	}
	public void setProductCompany(String productCompany) {
		this.productCompany = productCompany;
	}
	public String getProducCategory() {
		return producCategory;
	}
	public void setProducCategory(String producCategory) {
		this.producCategory = producCategory;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public Product(int productId, String productName, String productCompany, String producCategory,
			double productPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCompany = productCompany;
		this.producCategory = producCategory;
		this.productPrice = productPrice;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productCompany=" + productCompany
				+ ", producCategory=" + producCategory + ", productPrice=" + productPrice + "]";
	}
	
	 
}

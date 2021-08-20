package com.app.model;

public class Cart {
	private int cartId;
	private String cartEmail;
	private int cartProductId;
	private String cardProductName;
	private int quantity;
	private double cartProductPrice;
	
	public Cart() {
		
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public String getCardProductName() {
		return cardProductName;
	}
	public void setCardProductName(String cardProductName) {
		this.cardProductName = cardProductName;
	}
	public String getCartEmail() {
		return cartEmail;
	}
	public void setCartEmail(String cartEmail) {
		this.cartEmail = cartEmail;
	}
	public int getCartProductId() {
		return cartProductId;
	}
	public void setCartProductId(int cartProductId) {
		this.cartProductId = cartProductId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getCartProductPrice() {
		return cartProductPrice;
	}
	public void setCartProductPrice(double cartProductPrice) {
		this.cartProductPrice = cartProductPrice;
	}
	public Cart(int cartId, String cartEmail, int cartProductId, String cardProductName, int quantity,
			double cartProductPrice) {
		super();
		this.cartId = cartId;
		this.cartEmail = cartEmail;
		this.cartProductId = cartProductId;
		this.cardProductName = cardProductName;
		this.quantity = quantity;
		this.cartProductPrice = cartProductPrice;
	}
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", cartEmail=" + cartEmail + ", cartProductId=" + cartProductId
				+ ", cardProductName=" + cardProductName + ", quantity=" + quantity + ", cartProductPrice="
				+ cartProductPrice + "]";
	}
	
	
}

package com.app.customer.service;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Cart;

public interface CustomerServicePlaceOrder {
 
	public int placeOrder(String email) throws BusinessException;
}

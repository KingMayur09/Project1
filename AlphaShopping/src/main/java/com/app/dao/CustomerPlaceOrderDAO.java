package com.app.dao;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Cart;

public interface CustomerPlaceOrderDAO {

	public int placeOrder(String email) throws BusinessException;
}

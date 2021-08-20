package com.app.dao;

import com.app.exception.BusinessException;

public interface CustomerPlaceOrderDAO {

	public int placeOrder( String email) throws BusinessException;
}

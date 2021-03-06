package com.app.customer.service.impl;

import com.app.customer.service.CustomerServicePlaceOrder;
import com.app.dao.CustomerPlaceOrderDAO;
import com.app.dao.impl.CustomerPlaceOrderDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Cart;

public class CustomerServicePlaceOrderImpl implements CustomerServicePlaceOrder {

	@Override
	public int placeOrder(String email) throws BusinessException {
		
		CustomerPlaceOrderDAO newOrder=new CustomerPlaceOrderDAOImpl();
		if(email==null) {
			throw new BusinessException(" Email cannot be null");
		}
		int c=newOrder.placeOrder(email);
		return c;
	}

	
}

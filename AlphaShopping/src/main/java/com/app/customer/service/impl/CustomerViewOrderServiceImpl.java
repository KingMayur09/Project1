package com.app.customer.service.impl;

import java.util.List;

import com.app.customer.service.CustomerViewOrderService;
import com.app.dao.CustomerViewOrderDAO;
import com.app.dao.impl.CustomerViewOrderDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Order;
import com.app.validation.Validation;
import com.app.validationimpl.ValidationImpl;

public class CustomerViewOrderServiceImpl implements CustomerViewOrderService {

	@Override
	public List<Order> viewOrders(String email) throws BusinessException {
		Validation validate=new ValidationImpl();
		List<Order> orderList=null;
		if(email==null || !validate.isValidEmail(email)) {
			throw new BusinessException("Email should not Null and valid");
		}
		CustomerViewOrderDAO viewOrders=new CustomerViewOrderDAOImpl();
		orderList=viewOrders.viewOrders(email);
		
		return orderList;
	}

}

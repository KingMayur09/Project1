package com.app.dao;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Order;

public interface CustomerViewOrderDAO {

	 public List<Order> viewOrders(String email) throws BusinessException;
}

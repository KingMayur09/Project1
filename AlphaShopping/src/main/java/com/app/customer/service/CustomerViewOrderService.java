package com.app.customer.service;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Order;

public interface CustomerViewOrderService {

	 public List<Order> viewOrders(String email) throws BusinessException;
}

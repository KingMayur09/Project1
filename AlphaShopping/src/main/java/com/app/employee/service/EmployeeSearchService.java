package com.app.employee.service;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Order;

public interface EmployeeSearchService {

	public List<Order> searchByName(String name) throws BusinessException;
	public Order searchByEmail(String email) throws BusinessException;
}

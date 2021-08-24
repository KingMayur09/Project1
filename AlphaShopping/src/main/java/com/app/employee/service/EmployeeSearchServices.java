package com.app.employee.service;

import java.util.List;
import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.model.Order;

public interface EmployeeSearchServices {

	 public List<Order> searchCustomerByName(String firstName) throws BusinessException;
	 public List<Order> searchCustomerByEmail(String email) throws BusinessException;
	 public List<Order> searchCustomerByOrderId(int orderid) throws BusinessException;
	
	 
}

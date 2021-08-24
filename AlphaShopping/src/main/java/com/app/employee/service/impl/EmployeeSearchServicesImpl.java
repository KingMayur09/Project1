package com.app.employee.service.impl;

import java.util.List;

import com.app.dao.EmployeeSearchDAO;
import com.app.dao.impl.EmployeeSearchDAOImpl;
import com.app.employee.service.EmployeeSearchServices;
import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.model.Order;
import com.app.validation.Validation;
import com.app.validationimpl.ValidationImpl;

public class EmployeeSearchServicesImpl implements EmployeeSearchServices{

	@Override
	public List<Order> searchCustomerByName(String firstName) throws BusinessException {
		Validation validate=new ValidationImpl();
		List<Order> orderList=null;
		if(firstName==null && validate.isValidString(firstName)) {
			throw new BusinessException("Name should not contain number or special character and must not be null");
		}
		EmployeeSearchDAO search=new EmployeeSearchDAOImpl();
		orderList=search.searchCustomerByName(firstName);
		return orderList;
	}

	@Override
	public List<Order> searchCustomerByEmail(String email) throws BusinessException {
		Validation validate=new ValidationImpl();
		List<Order> orderList=null;
		if(email==null && validate.isValidEmail(email)) {
			throw new BusinessException("Invalid Email Id");
		}
		EmployeeSearchDAO search=new EmployeeSearchDAOImpl();
		orderList=search.searchCustomerByEmail(email);
		return orderList;
	}

	@Override
	public List<Order> searchCustomerByOrderId(int orderid) throws BusinessException {
		Validation validate=new ValidationImpl();
		List<Order> orderList=null;
		
		EmployeeSearchDAO search=new EmployeeSearchDAOImpl();
		orderList=search.searchCustomerByOrderId(orderid);
		return orderList;
	}

}

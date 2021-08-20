package com.app.customer.service.impl;

import com.app.customer.service.CustomerLoginService;
import com.app.dao.CustomerLoginDAO;
import com.app.dao.impl.CustomerLoginDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.validation.Validation;
import com.app.validationimpl.ValidationImpl;

public class CustomerLoginServiceImpl implements CustomerLoginService{

	@Override
	public Customer isUserExist(String email, String password) throws BusinessException {
		Customer customer=null;
		
		CustomerLoginDAO customerLoginDao=new CustomerLoginDAOImpl();
		Validation validate=new ValidationImpl();
		if(!validate.isValidEmail(email)) {
			throw new BusinessException("Invalid Email format "+email);
		}
		if(!validate.isValidPassword(password)) {
			throw new BusinessException("password can contain only aplabates and number ");
		}
		customer=customerLoginDao.CustomerLogin(email, password);
		
		return customer;
	}

}

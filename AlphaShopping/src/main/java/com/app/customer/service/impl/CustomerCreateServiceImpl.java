package com.app.customer.service.impl;

import com.app.customer.service.CustomerCreateService;
import com.app.dao.CustomerCreateDAO;
import com.app.dao.CustomerLoginDAO;
import com.app.dao.impl.CustomerCreateDAOImpl;
import com.app.dao.impl.CustomerLoginDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.validation.Validation;
import com.app.validationimpl.ValidationImpl;

public class CustomerCreateServiceImpl implements CustomerCreateService {

	@Override
	public int createNewCustomer(Customer customer) throws BusinessException {
		int c=0;
		
		CustomerLoginDAO customerLoginDao=new CustomerLoginDAOImpl();
		Validation validate=new ValidationImpl();
		if(!validate.isValidEmail(customer.getEmail())) {
			throw new BusinessException("Invalid format ");
		}
		if(!validate.isValidString(customer.getFirstName())) {
			throw new BusinessException("Name should not contain special character or number or space");
		}
		if(!validate.isValidString(customer.getLastName())) {
			throw new BusinessException("Last name should not contain special character or number or space");
		}
		if(!validate.isValidString(customer.getCity())) {
			throw new BusinessException("City name should not contain special character or number or space");
		}
		if(!validate.isValidPassword(customer.getPassword())) {
			throw new BusinessException("Password must contain atleast 8 character");
		}
		
		CustomerCreateDAO createCustomer=new CustomerCreateDAOImpl();
		c=createCustomer.createNewCustomer(customer);
		 
		return c;
	}

}

package com.app.customer.service;

import com.app.exception.BusinessException;
import com.app.model.Customer;

public interface CustomerLoginService {

	public Customer isUserExist(String email,String password) throws BusinessException;
}

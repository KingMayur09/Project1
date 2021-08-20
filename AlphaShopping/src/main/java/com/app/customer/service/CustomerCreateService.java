package com.app.customer.service;

import com.app.exception.BusinessException;
import com.app.model.Customer;

public interface CustomerCreateService {

	public int createNewCustomer(Customer customer) throws BusinessException;
}

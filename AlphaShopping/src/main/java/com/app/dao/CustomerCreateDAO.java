package com.app.dao;

import com.app.exception.BusinessException;
import com.app.model.Customer;

public interface CustomerCreateDAO {
	
	public int createNewCustomer(Customer customer) throws BusinessException;

}

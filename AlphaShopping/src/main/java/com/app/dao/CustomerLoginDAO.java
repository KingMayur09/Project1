package com.app.dao;

import com.app.exception.BusinessException;
import com.app.model.Customer;

public interface CustomerLoginDAO {

	public  Customer CustomerLogin(String email,String password) throws BusinessException;
}

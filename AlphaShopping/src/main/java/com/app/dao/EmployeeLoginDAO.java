package com.app.dao;

import com.app.exception.BusinessException;
import com.app.model.Employee;

public interface EmployeeLoginDAO {
	public Employee isEmployeeExist(String email,String password) throws BusinessException;

}

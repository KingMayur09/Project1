package com.app.employee.service;

import com.app.exception.BusinessException;
import com.app.model.Employee;

public interface EmployeeLoginService {
	
	public Employee isEmployeeExist(String email,String password) throws BusinessException;

}

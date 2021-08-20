package com.app.employee.service.impl;

import com.app.dao.EmployeeLoginDAO;
import com.app.dao.impl.EmployeeLoginDAOImpl;
import com.app.employee.service.EmployeeLoginService;
import com.app.exception.BusinessException;
import com.app.model.Employee;
import com.app.validation.Validation;
import com.app.validationimpl.ValidationImpl;

public class EmployeeLoginServiceImpl implements EmployeeLoginService{

	@Override
	public Employee isEmployeeExist(String email, String password) throws BusinessException {
		Employee employee=null;
		
		Validation validate=new ValidationImpl();
		if(!validate.isValidEmail(email)) {
			throw new BusinessException("Invalid Email format "+email);
		}
		if(!validate.isValidPassword(password)) {
			throw new BusinessException("password can contain only aplabates and number ");
		}
		
		EmployeeLoginDAO employeeLoginDao=new EmployeeLoginDAOImpl();
		employee=employeeLoginDao.isEmployeeExist(email, password);
		return employee;
	}

}

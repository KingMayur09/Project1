package com.app.employee.service;

import com.app.exception.BusinessException;

public interface EmployeeUpdateStatusService {

	public int updateStatusEMP(int orderid) throws BusinessException;
}

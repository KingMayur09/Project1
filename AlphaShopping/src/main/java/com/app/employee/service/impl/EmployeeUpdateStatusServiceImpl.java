package com.app.employee.service.impl;

import com.app.dao.EmployeeUpdateStatusDAO;
import com.app.dao.impl.EmployeeUpdateStatusDAOImpl;
import com.app.employee.service.EmployeeUpdateStatusService;
import com.app.exception.BusinessException;

public class EmployeeUpdateStatusServiceImpl implements EmployeeUpdateStatusService{

	@Override
	public int updateStatusEMP(int orderid) throws BusinessException {
		
		int c;
		EmployeeUpdateStatusDAO update=new EmployeeUpdateStatusDAOImpl();
		c=update.updateStatusEMP(orderid);
		return c;
	}

}

package com.app.dao;

import com.app.exception.BusinessException;

public interface EmployeeUpdateStatusDAO {

	public int updateStatusEMP(int orderid) throws BusinessException ;
}

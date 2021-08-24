package com.app.customer.service.impl;

import com.app.customer.service.CustomerUpdateStatusService;
import com.app.dao.CustomerUpdateStatusDAO;
import com.app.dao.impl.CustomerUpdateStatusDAOImpl;
import com.app.exception.BusinessException;
import com.app.validation.Validation;
import com.app.validationimpl.ValidationImpl;

public class CustomerUpdateStatusServiceImpl implements CustomerUpdateStatusService{

	@Override
	public int updateStatus(int orderId) throws BusinessException {
		int c=0;
		CustomerUpdateStatusDAO update=new CustomerUpdateStatusDAOImpl();
		c=update.updateStatus(orderId);
		return c;
	}

}

package com.app.customer.service;

import com.app.exception.BusinessException;

public interface CustomerUpdateStatusService {

	public int updateStatus(int orderId) throws BusinessException;
}

package com.app.dao;

import com.app.exception.BusinessException;

public interface CustomerUpdateStatusDAO {
	public int updateStatus(int orderId) throws BusinessException;
}

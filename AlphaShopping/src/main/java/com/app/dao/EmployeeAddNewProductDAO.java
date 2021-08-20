package com.app.dao;

import com.app.exception.BusinessException;
import com.app.model.Product;

public interface EmployeeAddNewProductDAO {
	public int addNewProduct(Product product) throws BusinessException;
}

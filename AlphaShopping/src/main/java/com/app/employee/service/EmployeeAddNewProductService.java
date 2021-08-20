package com.app.employee.service;

import com.app.exception.BusinessException;
import com.app.model.Product;

public interface EmployeeAddNewProductService {
 
	public int addNewProduct(Product product) throws BusinessException;
}

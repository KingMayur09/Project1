package com.app.customer.service;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Product;

public interface CustomerSearchServices {
	
	public List<Product> productSearchByName(String productName) throws BusinessException;
	public List<Product> productSearchByCompany(String productCompany) throws BusinessException;
	public List<Product> productSearchByCategory(String productCategory) throws BusinessException;

}

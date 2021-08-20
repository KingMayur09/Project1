package com.app.employee.service.impl;

import com.app.dao.EmployeeAddNewProductDAO;
import com.app.dao.impl.EmployeeAddNewProductDAOImpl;
import com.app.employee.service.EmployeeAddNewProductService;
import com.app.exception.BusinessException;
import com.app.model.Product;
import com.app.validation.Validation;
import com.app.validationimpl.ValidationImpl;

public class EmployeeAddNewProductServiceImpl implements EmployeeAddNewProductService{

	@Override
	public int addNewProduct(Product product) throws BusinessException {
		Validation validate=new ValidationImpl();
		
		if(product.getProductName() == null ||  !validate.isValidString((product.getProductName()))) {
			throw new BusinessException("Name should not contain special character or number or space and not null");
		}
		if(product.getProducCategory() == null ||  !validate.isValidString((product.getProductName()))) {
			throw new BusinessException("Name should not contain special character or number or space and not null");
		}
		if(product.getProductCompany() == null ||  !validate.isValidString((product.getProductName()))) {
			throw new BusinessException("Name should not contain special character or number or space and not null");
		}
		EmployeeAddNewProductDAO newProduct=new EmployeeAddNewProductDAOImpl();
		int c=newProduct.addNewProduct(product);
		return c;
	}
}

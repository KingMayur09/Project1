package com.app.customer.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.Main;
import com.app.customer.service.CustomerSearchServices;
import com.app.dao.CustomerSearchServicesDAO;
import com.app.dao.impl.CustomerSearchServicesDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Product;
import com.app.validation.Validation;
import com.app.validationimpl.ValidationImpl;

public class CustomerSearchServicesImpl implements CustomerSearchServices{
	Validation validate=new ValidationImpl();
	public static Logger log=Logger.getLogger(Main.class);
	@Override
	public List<Product> productSearchByName(String productName) throws BusinessException {
		List<Product> productList=new ArrayList<>();
		if(!validate.isValidString(productName) || productName==null) {
			 throw new BusinessException("product name should not contain special character or number and must not null");
		}
		CustomerSearchServicesDAO customerSearchServicesDAO = new CustomerSearchServicesDAOImpl();
		productList=customerSearchServicesDAO.productSearchByName(productName);
		return productList;
	}

	@Override
	public List<Product> productSearchByCompany(String productCompany) throws BusinessException {
		List<Product> productList=new ArrayList<>();
		if(!validate.isValidString(productCompany) || productCompany==null) {
			 throw new BusinessException("product company name should not contain special character or number and must not null");
		}
		CustomerSearchServicesDAO customerSearchServicesDAO = new CustomerSearchServicesDAOImpl();
		productList=customerSearchServicesDAO.productSearchByCompany(productCompany);
		return productList;
	}

	@Override
	public List<Product> productSearchByCategory(String productCategory) throws BusinessException {
		List<Product> productList=new ArrayList<>();
		if(!validate.isValidString(productCategory) || productCategory==null) {
			 throw new BusinessException("product category name should not contain special character or number and must not null");
		}
		CustomerSearchServicesDAO customerSearchServicesDAO = new CustomerSearchServicesDAOImpl();
		productList=customerSearchServicesDAO.productSearchByCategory(productCategory);
		return productList;
	}

}

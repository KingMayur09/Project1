package com.app.validation;

import com.app.exception.BusinessException;

public interface Validation {
	
	public boolean isValidEmail(String email) throws BusinessException;
	public boolean isValidPassword(String password) throws BusinessException;
	public boolean isValidString(String string) throws BusinessException;
	

}
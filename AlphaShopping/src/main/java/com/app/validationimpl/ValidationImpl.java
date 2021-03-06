package com.app.validationimpl;

import com.app.exception.BusinessException;
import com.app.validation.Validation;

public class ValidationImpl implements Validation {

	@Override
	public boolean isValidEmail(String email) throws BusinessException {
		
		 boolean isValid=false ;
		 if(email.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
			isValid=true;
		 }
		 return isValid;
	}

	@Override
	public boolean isValidPassword(String password) throws BusinessException {
		boolean isValid=false;
		if(password.matches("[a-zA-z0-9@_#]{8,20}")) {
			
			isValid=true;
		}
		return isValid;
	}

	@Override
	public boolean isValidString(String string) throws BusinessException {
		boolean isValid=false;
		if(string.matches("[a-zA-Z]{2,20}")) {
			
			isValid=true;
		}
		return isValid;
	}

}

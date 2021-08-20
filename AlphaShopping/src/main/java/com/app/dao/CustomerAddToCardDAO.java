package com.app.dao;

import com.app.exception.BusinessException;
import com.app.model.Cart;

public interface CustomerAddToCardDAO {
	
	public Cart addToCart(int productId,String email,int quantity) throws BusinessException;

}

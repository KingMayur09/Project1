package com.app.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.app.dao.CustomerViewOrderDAO;
import com.app.exception.BusinessException;
import com.app.model.Order;
import com.app.util.MysqlDbConnection;

public class CustomerViewOrderDAOImpl implements CustomerViewOrderDAO{

	@Override
	public List<Order> viewOrders(String email) throws BusinessException {
		List<Order> orderList=null;
		try(Connection connection =MysqlDbConnection.getConnection()){
			
			String sql="select orderid,email,productId,ProductPrice,productName,quantity,Status from order where email=?";
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderList;
	}
	
}

package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.Main;
import com.app.dao.CustomerViewOrderDAO;
import com.app.exception.BusinessException;
import com.app.model.Order;
import com.app.util.MysqlDbConnection;

public class CustomerViewOrderDAOImpl implements CustomerViewOrderDAO{
	public static Logger log=Logger.getLogger(Main.class);
	@Override
	public List<Order> viewOrders(String email) throws BusinessException {
		List<Order> orderList=new ArrayList<>();
		try(Connection connection =MysqlDbConnection.getConnection()){
			
			String sql="select orderId,email,productId,ProductPrice,productName,quantity,Status from alpha_shopping.order where email=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Order order=new Order();
				
				order.setEmail(email);
				order.setOrderid(resultSet.getInt("orderId"));
				order.setProductId(resultSet.getInt("productId"));
				order.setProductName(resultSet.getString("productName"));
				order.setProductPrice(resultSet.getDouble("ProductPrice"));
				order.setQuantity(resultSet.getInt("quantity"));
				order.setStatus(resultSet.getString("Status"));
				orderList.add(order);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			log.warn("Internal error occured");
		}
		return orderList;
	}
	
}

package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.app.Main;
import com.app.dao.CustomerPlaceOrderDAO;
import com.app.exception.BusinessException;
import com.app.util.MysqlDbConnection;

public class CustomerPlaceOrderDAOImpl implements CustomerPlaceOrderDAO {
	private static Logger log = Logger.getLogger(Main.class);

	@Override
	public int placeOrder(String email) throws BusinessException {
		int c = 0;
		try (Connection connection = MysqlDbConnection.getConnection()) {

			String sql = "insert into order (orderId,email,productId,productName,productPrice,quantity)"
					+ " select cartid,cartEmail,cartProductId,cartProductName,cartProductPrice,quantity from cart c where c.cartEmail=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			c = preparedStatement.executeUpdate();
			if(c>0) {log.info("succecc order");}
		} catch (ClassNotFoundException | SQLException e) {
			log.info("Internal Error occured");
		}
		return c;
	}
}
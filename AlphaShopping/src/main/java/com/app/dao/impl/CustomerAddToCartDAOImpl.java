package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.log4j.Logger;
import com.app.Main;
import com.app.dao.CustomerAddToCardDAO;
import com.app.exception.BusinessException;
import com.app.model.Cart;
import com.app.util.MysqlDbConnection;

public class CustomerAddToCartDAOImpl implements CustomerAddToCardDAO {
	public static Logger log = Logger.getLogger(Main.class);

	@Override
	public Cart addToCart(int productId, String email, int quantity) throws BusinessException {
		Cart cart=new Cart();
		try (Connection connection = MysqlDbConnection.getConnection()) {
			String sql = "select productId,productName,productPrice from product where productId=? ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, productId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String sq = "insert into cart(cartEmail,cartProductId,quantity,cartProductPrice,cartProductName) values(?,?,?,?,?)";
			PreparedStatement preparedStatement1 = connection.prepareStatement(sq, Statement.RETURN_GENERATED_KEYS);
			preparedStatement1.setString(1, email);
			preparedStatement1.setInt(2, resultSet.getInt("productId"));
			preparedStatement1.setInt(3, quantity);
			preparedStatement1.setDouble(4, resultSet.getDouble("productPrice"));
			preparedStatement1.setString(5, resultSet.getString("productName"));
			int c = preparedStatement1.executeUpdate();
			if (c == 1) {
				ResultSet resultSet1 = preparedStatement1.getGeneratedKeys();
				if(resultSet1.next()) {
					cart.setCartId(resultSet1.getInt(1));
				}
				cart.setCartEmail(email);
				cart.setCardProductName(resultSet.getString("productName"));
				cart.setCartProductId(resultSet.getInt("productId"));
				cart.setCartProductPrice(resultSet.getDouble("productPrice"));
				cart.setQuantity(quantity);
			}

		} catch (ClassNotFoundException | SQLException e) {
			log.info(e.getMessage());
		}
		return cart;
	}

}

package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.app.Main;
import com.app.dao.EmployeeAddNewProductDAO;
import com.app.exception.BusinessException;
import com.app.model.Product;
import com.app.util.MysqlDbConnection;


public class EmployeeAddNewProductDAOImpl implements EmployeeAddNewProductDAO{
	private static Logger log = Logger.getLogger(Main.class);
	@Override
	public int addNewProduct(Product product) throws BusinessException {
		int c=0;
		try(Connection connection =MysqlDbConnection.getConnection()){
			String sql="insert into product (productId,productName,productCompany,productCategory,productPrice) values(?,?,?,?,?)";
			PreparedStatement prepareStatement=connection.prepareStatement(sql);
			prepareStatement.setInt(1, product.getProductId());
			prepareStatement.setString(2, product.getProductName());
			prepareStatement.setString(3, product.getProductCompany());
			prepareStatement.setString(4, product.getProductCompany());
			prepareStatement.setDouble(5, product.getProductPrice());
			c=prepareStatement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			log.warn("Internal Error Occured");
		}
		return c;
		
	}

}

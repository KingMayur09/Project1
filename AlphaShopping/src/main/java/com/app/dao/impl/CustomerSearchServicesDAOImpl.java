package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.Main;
import com.app.dao.CustomerSearchServicesDAO;
import com.app.exception.BusinessException;
import com.app.model.Product;
import com.app.util.MysqlDbConnection;

public class CustomerSearchServicesDAOImpl implements CustomerSearchServicesDAO {
	public static Logger log = Logger.getLogger(Main.class);

	@Override
	public List<Product> productSearchByName(String productName) throws BusinessException {
		List<Product> productList = new ArrayList<>();
		try (Connection connection = MysqlDbConnection.getConnection()) {
			String sql = "select productId,productName,productCompany,productCategory,productPrice from product where productName=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, productName);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Product product = new Product();
				product.setProductId(resultSet.getInt("productId"));
				product.setProductName(resultSet.getString("productName"));
				product.setProductCompany(resultSet.getString("productCompany"));
				product.setProducCategory(resultSet.getString("productCategory"));
				product.setProductPrice(resultSet.getDouble("productPrice"));
				productList.add(product);
			}
			if (productList.size() == 0) {
				log.info("No result for this search " + productName + " Try again");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.warn("Internal error Occured");
		}
		return productList;
	}

	@Override
	public List<Product> productSearchByCompany(String productCompany) throws BusinessException {
		List<Product> productList = new ArrayList<>();
		try (Connection connection = MysqlDbConnection.getConnection()) {
			
			String sql = "select productId,productName,productCompany,productCategory,productPrice from product where productCompany=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, productCompany);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Product product = new Product();
				product.setProductId(resultSet.getInt("productId"));
				product.setProductName(resultSet.getString("productName"));
				product.setProductCompany(resultSet.getString("productCompany"));
				product.setProducCategory(resultSet.getString("productCategory"));
				product.setProductPrice(resultSet.getDouble("productPrice"));
				productList.add(product);
			}
			if (productList.size() == 0) {
				log.info("No result for this search " + productCompany + " Try again");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.warn("Internal error Occured");
		}
		return productList;
	}

	@Override
	public List<Product> productSearchByCategory(String productCategory) throws BusinessException {
		List<Product> productList = new ArrayList<>();
		try (Connection connection = MysqlDbConnection.getConnection()) {
			
			String sql = "select productId,productName,productCompany,productCategory,productPrice from product where productCategory=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, productCategory);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Product product = new Product();
				product.setProductId(resultSet.getInt("productId"));
				product.setProductName(resultSet.getString("productName"));
				product.setProductCompany(resultSet.getString("productCompany"));
				product.setProducCategory(resultSet.getString("productCategory"));
				product.setProductPrice(resultSet.getDouble("productPrice"));
				productList.add(product);
			}
			if (productList.size() == 0) {
				log.info("No result for this search " + productCategory + " Try again");
			}

		} catch (ClassNotFoundException | SQLException e) {
			log.warn("Internal error Occured");
		}
		return productList;
	}

}

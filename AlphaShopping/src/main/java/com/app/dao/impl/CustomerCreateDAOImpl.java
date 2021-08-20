package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.app.Main;
import com.app.dao.CustomerCreateDAO;
import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.util.MysqlDbConnection;

public class CustomerCreateDAOImpl implements CustomerCreateDAO{
	public static Logger log=Logger.getLogger(Main.class);
	@Override
	public int createNewCustomer(Customer customer) throws BusinessException {
		int c=0;
		try(Connection connection=MysqlDbConnection.getConnection()){
			String sql="insert into customer(email,firstName,lastName,city,password) values(?,?,?,?,?)";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, customer.getEmail());
			preparedStatement.setString(2, customer.getFirstName());
			preparedStatement.setString(3, customer.getLastName());
			preparedStatement.setString(4, customer.getCity());
			preparedStatement.setString(5, customer.getPassword());
			c=preparedStatement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			log.warn("Internal Error Occured , Sorry For inconvenience :(");
		}
		return c;
	}

}

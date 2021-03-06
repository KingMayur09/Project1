package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.app.Main;
import com.app.dao.CustomerLoginDAO;
import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.util.MysqlDbConnection;

public class CustomerLoginDAOImpl implements CustomerLoginDAO{
	public static Logger log=Logger.getLogger(Main.class);
	@Override
	public Customer CustomerLogin(String email, String password) throws BusinessException {
		Customer customer=null;
		try(Connection connection=MysqlDbConnection.getConnection()){
			
			String sql="select email,firstName,lastName,city,password from customer";
			PreparedStatement preparedStatement =connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				if(email.equals(resultSet.getString("email")) && password.equals(resultSet.getString("password"))) {
					customer =new Customer();
					customer.setEmail(email);
					customer.setFirstName(resultSet.getString("firstName"));
					customer.setLastName(resultSet.getString("lastName"));
					customer.setCity(resultSet.getString("city"));
					break;
				}
			}
			if(customer==null) {
				log.info("Customer with this credential does existed Try again ! :)");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			log.warn("Internal Error Occured :(");
		}
		return customer;
	}

	
}

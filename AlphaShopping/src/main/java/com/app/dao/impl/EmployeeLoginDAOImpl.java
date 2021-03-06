package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.app.Main;
import com.app.dao.EmployeeLoginDAO;
import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.model.Employee;
import com.app.util.MysqlDbConnection;

public class EmployeeLoginDAOImpl implements EmployeeLoginDAO{
	public static Logger log=Logger.getLogger(Main.class);
	@Override
	public Employee isEmployeeExist(String email, String password) throws BusinessException {
		Employee employee=null;
		try(Connection connection=MysqlDbConnection.getConnection()){
			
			String sql="select email,employeeName,employeePassword from employee";
			PreparedStatement preparedStatement =connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			
				while(resultSet.next()) {
					if(email.equals(resultSet.getString("email")) && password.equals(resultSet.getString("employeePassword"))) {
						employee =new Employee();
						employee.setEmail(email);
						employee.setEmployeeName(resultSet.getString("employeeName"));
						break;
					}
				}
			
			if(employee==null) {
				log.info("Employee Login Failed :)");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			log.warn("Internal Error Occured :(");
		}
		return employee;
	}
}



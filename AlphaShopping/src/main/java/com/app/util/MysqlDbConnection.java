package com.app.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlDbConnection {
	
	private static Connection connection;
	private  MysqlDbConnection() {
		
	}
	public static Connection getConnection() throws ClassNotFoundException,SQLException{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/alpha_shopping";
		String userName="root";
		String password="Root@123";
		return connection=DriverManager.getConnection(url,userName,password);
	}

}

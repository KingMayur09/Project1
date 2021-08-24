package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.app.Main;
import com.app.dao.EmployeeUpdateStatusDAO;
import com.app.exception.BusinessException;
import com.app.util.MysqlDbConnection;

public class EmployeeUpdateStatusDAOImpl implements EmployeeUpdateStatusDAO {
	public static Logger log=Logger.getLogger(Main.class);
	@Override
	public int updateStatusEMP(int orderid) throws BusinessException {
		int c=0;
		try(Connection connection=MysqlDbConnection.getConnection()){
			String shipped="SHIPPED";
			String sql="update alpha_shopping.order set status=? where orderId=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, shipped);
			preparedStatement.setInt(2, orderid);
			 c=preparedStatement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			log.warn("Internal Error Occured");
		}
		return c;
		
	}

}

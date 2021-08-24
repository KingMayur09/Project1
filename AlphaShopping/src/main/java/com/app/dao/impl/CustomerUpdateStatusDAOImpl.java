package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.app.Main;
import com.app.dao.CustomerUpdateStatusDAO;
import com.app.exception.BusinessException;
import com.app.util.MysqlDbConnection;

public class CustomerUpdateStatusDAOImpl implements CustomerUpdateStatusDAO {
	public static Logger log=Logger.getLogger(Main.class);
	@Override
	public int updateStatus(int orderId) throws BusinessException {
		
		int c=0;
		try(Connection connection=MysqlDbConnection.getConnection()){
			String received="RECEIVED";
			String sql="update alpha_shopping.order set status=? where orderId=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, received);
			preparedStatement.setInt(2, orderId);
			 c=preparedStatement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			log.warn("Internal Error Occured");
		}
		return c;
	}

}

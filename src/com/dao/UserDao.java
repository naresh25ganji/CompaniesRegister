package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.User;
import com.util.DatabaseUtil;

public class UserDao {
private Connection connection;
	
	public UserDao() {
        connection = DatabaseUtil.getConnection();
    }
	
    public boolean authenticateUser(User user) {
    	boolean loginSuccess = false;
    	try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("Select USERNAME,PASSWORD from users where USERNAME=? and PASSWORD=?");
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassword());
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
            	loginSuccess = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return loginSuccess;	
	}
}

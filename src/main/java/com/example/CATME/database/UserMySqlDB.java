package com.example.CATME.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.CATME.user.User;

/**
 * UserMySqlDB implmentation mysql database.
 * using the MOCK data to do testing
 * @author Ruize Nie
 * @version 1.0
 */
public class UserMySqlDB implements UserDB{

	private Connection dbConnection;
	
	public Connection getDBConnection() {
	    try {
			dbConnection = DriverManager.getConnection(
					"jdbc:mysql://db-5308.cs.dal.ca/CSCI5308_21_TEST?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", 
					"CSCI5308_21_TEST_USER", 
					"CSCI5308_21_TEST_21529");
			return dbConnection;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	  }
	
	public ResultSet executeQuery(String query) {
	    try {
	    	getDBConnection();
			return dbConnection.createStatement().executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	  }

	@Override
	public User findUserByEmail(String email) {
		getDBConnection();
		String query = "SELECT * FROM USER WHERE email = '" + email +"'";
		ResultSet myRs = executeQuery(query);
		try {
			while(myRs.next()) {
				User user = new User();
				user.setUserId(myRs.getString("user_id"));
				user.setEmail(myRs.getString("email"));
				user.setPassword(myRs.getString("password"));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}

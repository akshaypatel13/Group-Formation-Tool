package com.example.CATME.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * MySQLConnection class for mysql instance.
 * @author Ruize Nie
 * @version 1.0
 */
public class MySQLConnection {
	
	private Connection dbConnection;
	
	public Connection getDBConnection() {
		if(dbConnection == null) {
		    try {
				dbConnection = DriverManager.getConnection(
						"jdbc:mysql://db-5308.cs.dal.ca/CSCI5308_21_TEST?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", 
						"CSCI5308_21_TEST_USER", 
						"CSCI5308_21_TEST_21529");
				return dbConnection;
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
		return dbConnection;
	  }
	
	public void closeConnection() {
		if(dbConnection!=null) {
			try {
				dbConnection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public ResultSet selectQuery(String query) {
	    try {
	    	
	    	ResultSet rs = getDBConnection().createStatement().executeQuery(query);
	    	closeConnection();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	  }
	
	public int updateQuery(String query) {
	    try {
	    	int rs = getDBConnection().createStatement().executeUpdate(query);
	    	closeConnection();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	  }
}

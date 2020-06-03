package com.example.CATME.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.example.CATME.user.User;

/**
 * MySQLConnection class for mysql instance.
 * 
 * @author Ruize Nie
 * @version 1.0
 */
public class MySQLConnection {
	
	private Connection dbConnection;
	
	public Connection getDBConnection() {
		if(dbConnection == null) {
		    try {
				dbConnection = DriverManager.getConnection(
						"jdbc:mysql://db-5308.cs.dal.ca/CSCI5308_21_DEVINT?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", 
						"CSCI5308_21_DEVINT_USER", 
						"CSCI5308_21_DEVINT_21168");
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

	// static method for close connection
	public static void closeConnection(Connection conn, Statement st) {
		try {
			if (st != null)
				st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

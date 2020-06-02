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

//	private Connection dbConnection;

	private static String dbURL = "jdbc:mysql://db-5308.cs.dal.ca/CSCI5308_21_TEST?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static String dbUserName = "CSCI5308_21_TEST_USER";
	private static String dbPassword = "CSCI5308_21_TEST_21529";

	// static method for get connection
	public static Connection getConnection() throws Exception {
		Connection conn = DriverManager.getConnection(dbURL, dbUserName, dbPassword);
		return conn;
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

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


	private static String dbURL = System.getenv("db_url");
	private static String dbUserName = System.getenv("db_username");;
	private static String dbPassword = System.getenv("db_pass");


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

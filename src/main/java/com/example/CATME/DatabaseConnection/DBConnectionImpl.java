package com.example.CATME.DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionImpl {

	public static String url="jdbc:mysql://db-5308.cs.dal.ca:3306/CSCI5308_21_TEST?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	public static String driver="com.mysql.cj.jdbc.Driver";
	public static String username="CSCI5308_21_TEST_USER";
	public static String password="CSCI5308_21_TEST_21529";
	
	public static Connection connection;
	
	public static Connection createConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url, username, password);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Database Connection Unsuccessful");
		}
		
		return connection;
	}
	
	
}

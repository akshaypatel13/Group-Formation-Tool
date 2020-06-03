package com.example.CATME.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.example.CATME.user.User;

public class MySQLOperationForUser extends MySQLConnection {

	public User findUser(String query) {
		Connection conn = null;
		Statement st = null;
		try {
			// step 1: object connection from Mysql Connection util
			conn = MySQLConnection.getConnection();
			// step 2: create the statement to run the sql
			st = conn.createStatement();
			// step 3: run the sql
			ResultSet myRs = st.executeQuery(query);

			while (myRs.next()) {
				User user = new User();
				user.setUserId(myRs.getString("user_id"));
				user.setBannerId(myRs.getString("banner_id"));
				user.setFirstName(myRs.getString("first_name"));
				user.setLastName(myRs.getString("last_name"));
				user.setEmail(myRs.getString("email"));
				user.setPassword(myRs.getString("password"));
				user.setResetToken(myRs.getString("reset_token"));
				return user;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// step 6: close the connection
			MySQLConnection.closeConnection(conn, st);
		}
		return null;
	}

	public int updateUser(String query) {
		Connection conn = null;
		Statement st = null;
		try {
			// step 1: object connection from Mysql Connection util
			conn = MySQLConnection.getConnection();
			// step 2: create the statement to run the sql
			st = conn.createStatement();
			// step 3: run the sql
			return st.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// step 6: close the connection
			MySQLConnection.closeConnection(conn, st);
		}
		return 0;
	}
}

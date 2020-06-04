package com.example.CATME.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.UUID;

import com.example.CATME.user.User;

public class UserSignUpDBImpl implements UserSignUpDB {

	private MySQLConnection myConn = new MySQLConnection();

	@Override
	public boolean insertGuestUser(User user) {

		final String uuid = UUID.randomUUID().toString().replace("-", "");
		final String rid = UUID.randomUUID().toString().replace("-", "");
		String query1 = "Insert into user(user_id ,banner_id, first_name , last_name ,username,password) " + "Values ('"
				+ uuid + "', '" + user.getBannerId() + "','" + user.getFirstName() + "','" + user.getLastName()
				+ "' , '" + user.getEmail() + "','" + user.getPassword() + "');";

		String query2 = "Insert into authorities(auth_id,username,authority) " + "Values ('" + rid + "' ,'"
				+ user.getEmail() + "','ROLE_GUEST' );";

		Connection conn = null;
		Statement st = null;
		Statement st1 = null;
		try {
			// step 1: object connection from Mysql Connection util
			conn = MySQLConnection.getConnection();
			// step 2: create the statement to run the sql
			st = conn.createStatement();
			st1 = conn.createStatement();
			// step 3: run the sql
			st.executeUpdate(query1);
			st1.executeUpdate(query2);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// step 6: close the connection
			MySQLConnection.closeConnection(conn, st);
			MySQLConnection.closeConnection(conn, st1);
		}
		return true;
	}

	@Override
	public boolean insertStudentUser(User user, int courseID) {
		final String uuid = UUID.randomUUID().toString().replace("-", "");
		final String rid = UUID.randomUUID().toString().replace("-", "");
		String query1 = "Insert into user(user_id ,banner_id, first_name , last_name ,username,password) " + "Values ('"
				+ uuid + "', '" + user.getBannerId() + "','" + user.getFirstName() + "','" + user.getLastName()
				+ "' , '" + user.getEmail() + "','" + user.getPassword() + "');";

		String query2 = "Insert into authorities(auth_id,username,authority, course_id) " + "Values ('" + rid + "' ,'"
				+ user.getEmail() + "','ROLE_STUDENT', " + courseID + " );";

		Connection conn = null;
		Statement st = null;
		Statement st1 = null;
		try {
			// step 1: object connection from Mysql Connection util
			conn = MySQLConnection.getConnection();
			// step 2: create the statement to run the sql
			st = conn.createStatement();
			st1 = conn.createStatement();
			// step 3: run the sql
			st.executeUpdate(query1);
			st1.executeUpdate(query2);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// step 6: close the connection
			MySQLConnection.closeConnection(conn, st);
		}
		return true;
	}

	@Override
	public boolean findUserByEmail(String email) {
		String query = "SELECT * FROM user WHERE username = '" + email + "'";
		Connection conn = null;
		Statement st = null;
		try {
			// step 1: object connection from Mysql Connection util
			conn = MySQLConnection.getConnection();
			// step 2: create the statement to run the sql
			st = conn.createStatement();
			// step 3: run the sql
			ResultSet myRs = st.executeQuery(query);
			if (myRs.next()) {
				return true;
			} else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// step 6: close the connection
			MySQLConnection.closeConnection(conn, st);
		}
		return false;
	}

	@Override
	public boolean findUserByBannerId(String bannerId) {
		String query = "SELECT * FROM user WHERE banner_id = '" + bannerId + "'";
		Connection conn = null;
		Statement st = null;
		try {
			// step 1: object connection from Mysql Connection util
			conn = MySQLConnection.getConnection();
			// step 2: create the statement to run the sql
			st = conn.createStatement();
			// step 3: run the sql
			ResultSet myRs = st.executeQuery(query);
			if (myRs.next()) {

				return true;
			} else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// step 6: close the connection
			MySQLConnection.closeConnection(conn, st);
		}

		return false;
	}
}

package com.example.CATME.database;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.example.CATME.user.User;
/**
 * @author Ruize Nie
 * @version 1.0
 */
@Repository
public class UserResetPasswordDBImpl implements UserResetPasswordDB {
	
	private MySQLConnection mysql = new MySQLConnection();
	
	@Override
	public User findUserByEmail(String email) {
		String query = "SELECT * FROM USER WHERE email = '" + email +"'";
		ResultSet myRs = mysql.selectQuery(query);
		try {
			while(myRs.next()) {
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void saveUserResetToken(User user) {
		
		String userId = user.getUserId();
		String resetToken = user.getResetToken();
		String query = "UPDATE USER SET reset_token = '" + resetToken +"' WHERE user_id = '" + userId + "'";
		mysql.updateQuery(query);

	}

	@Override
	public User findUserByResetToken(String resetToken) {
		String query = "SELECT * FROM USER WHERE reset_token = '" + resetToken +"'";
		ResultSet myRs = mysql.selectQuery(query);
		try {
			while(myRs.next()) {
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void saveUserPassword(User user) {
		
		String userId = user.getUserId();
		String password = user.getPassword();
		String query = "UPDATE USER SET password = '" + password +"' WHERE user_id = '" + userId + "'";
		mysql.updateQuery(query);
		
	}

}

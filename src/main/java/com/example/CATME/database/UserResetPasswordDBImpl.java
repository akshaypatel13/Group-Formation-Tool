package com.example.CATME.database;

import org.springframework.stereotype.Repository;

import com.example.CATME.user.User;
/**
 * @author Ruize Nie
 * @version 1.0
 */
@Repository
public class UserResetPasswordDBImpl implements UserResetPasswordDB {
	
	private MySQLOperationForUser mysql = new MySQLOperationForUser();
	
	@Override
	public User findUserByEmail(String email) {
		String query = "SELECT * FROM user WHERE username = '" + email +"'";
		return mysql.findUser(query);
	}

	@Override
	public void saveUserResetToken(User user) {
		
		String userId = user.getUserId();
		String resetToken = user.getResetToken();
		String query = "UPDATE user SET reset_token = '" + resetToken +"' WHERE user_id = '" + userId + "'";
		mysql.updateUser(query);

	}

	@Override
	public User findUserByResetToken(String resetToken) {
		String query = "SELECT * FROM user WHERE reset_token = '" + resetToken +"'";
		return mysql.findUser(query);
	}

	@Override
	public void saveUserPassword(User user) {
		
		String userId = user.getUserId();
		String password = user.getPassword();
		String query = "UPDATE user SET password = '" + password +"' WHERE user_id = '" + userId + "'";
		mysql.updateUser(query);
		
	}

}

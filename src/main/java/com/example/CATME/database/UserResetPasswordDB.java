package com.example.CATME.database;

import com.example.CATME.user.User;
/**
 * @author Ruize Nie
 * @version 1.0
 */
public interface UserResetPasswordDB {
	public User findUserByEmail(String email);
	public void saveUserResetToken(User user);
	public User findUserByResetToken(String resetToken);
	public void saveUserPassword(User user);
}

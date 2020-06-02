package com.example.CATME.resetpassword;

import com.example.CATME.database.UserResetPasswordDB;
import com.example.CATME.user.User;

/**
 * UserResetPasswordDAO Interface for user data access object.
 * @author Ruize Nie
 * @version 1.0
 */
public interface UserResetPasswordDAO {
	public User findUserByEmail(UserResetPasswordDB userResetPasswordDB, String email);
	public void saveUserResetToken(UserResetPasswordDB userResetPasswordDB, User user);
	public User findUserByResetToken(UserResetPasswordDB userResetPasswordDB, String resetToken);
	public void saveUserPassword(UserResetPasswordDB userResetPasswordDB, User user);
	
}

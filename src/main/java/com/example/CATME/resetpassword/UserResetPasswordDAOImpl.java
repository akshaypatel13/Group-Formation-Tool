package com.example.CATME.resetpassword;

import org.springframework.stereotype.Repository;

import com.example.CATME.database.UserResetPasswordDB;
import com.example.CATME.user.User;
@Repository
public class UserResetPasswordDAOImpl implements UserResetPasswordDAO {

	@Override
	public User findUserByEmail(UserResetPasswordDB userResetPasswordDB, String email) {
		return userResetPasswordDB.findUserByEmail(email);
	}

	@Override
	public void saveUserResetToken(UserResetPasswordDB userResetPasswordDB, User user) {
		userResetPasswordDB.saveUserResetToken(user);
	}

	@Override
	public User findUserByResetToken(UserResetPasswordDB userResetPasswordDB, String resetToken) {
		return userResetPasswordDB.findUserByResetToken(resetToken);
	}

	@Override
	public void saveUserPassword(UserResetPasswordDB userResetPasswordDB, User user) {
		userResetPasswordDB.saveUserPassword(user);
	}


}

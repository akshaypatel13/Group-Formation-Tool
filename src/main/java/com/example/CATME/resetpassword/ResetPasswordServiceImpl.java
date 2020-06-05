package com.example.CATME.resetpassword;


import org.springframework.stereotype.Service;

import com.example.CATME.database.UserResetPasswordDB;
import com.example.CATME.user.User;
@Service
public class ResetPasswordServiceImpl implements ResetPasswordService {

	private UserResetPasswordDAO userResetPasswordDAO;
	private UserResetPasswordDB userResetPasswordDB;
	
	public ResetPasswordServiceImpl(UserResetPasswordDAO userResetPasswordDAO,
			UserResetPasswordDB userResetPasswordDB) {
		this.userResetPasswordDAO = userResetPasswordDAO;
		this.userResetPasswordDB = userResetPasswordDB;
	}

	@Override
	public User findUserByEmail(String email) {
		User user = userResetPasswordDAO.findUserByEmail(userResetPasswordDB, email);
		return user;
	}

	@Override
	public void saveUserResetToken(User user) {
		userResetPasswordDAO.saveUserResetToken(userResetPasswordDB, user);
	}

	@Override
	public User findUserByResetToken(String resetToken) {
		User user = userResetPasswordDAO.findUserByResetToken(userResetPasswordDB, resetToken);
		return user;
	}

	@Override
	public void saveUserPassword(User user) {
		userResetPasswordDAO.saveUserPassword(userResetPasswordDB, user);
	}

}

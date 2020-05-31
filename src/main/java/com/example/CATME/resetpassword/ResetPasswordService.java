package com.example.CATME.resetpassword;

import com.example.CATME.user.User;

public interface ResetPasswordService {
	public User findUserByEmail(String email);
	public void saveUserResetToken(User user);
	public User findUserByResetToken(String resetToken);
	public void saveUserPassword(User user);
}

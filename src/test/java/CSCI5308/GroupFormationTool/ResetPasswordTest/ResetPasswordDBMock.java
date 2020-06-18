package CSCI5308.GroupFormationTool.ResetPasswordTest;

import CSCI5308.GroupFormationTool.AccessControl.User;

import CSCI5308.GroupFormationTool.Resetpassword.IUserResetPasswordDB;

public class ResetPasswordDBMock implements IUserResetPasswordDB {
	public void saveUserResetToken(User user) {
		user.setResetToken("12345");
	}

	public User findUserByResetToken(String resetToken) {
		User user = new User();
		user.setFirstName("Akash");
		user.setLastName("Bharti");
		user.setBannerID("B000000");
		user.setPassword("password");
		user.setResetToken("12345");
		return user;

	}

	public void saveUserPassword(User user) {
		user.setPassword("password");
	}

}

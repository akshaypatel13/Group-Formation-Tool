package CSCI5308.GroupFormationTool.resetpassword;


import CSCI5308.GroupFormationTool.AccessControl.User;

public interface IResetPasswordService {
	public void saveUserResetToken(User user);
	public User findUserByResetToken(String resetToken);
	public void saveUserPassword(User user);
}

package CSCI5308.GroupFormationTool.resetpassword;


import CSCI5308.GroupFormationTool.AccessControl.User;


public interface IUserResetPasswordDAO {
	public void saveUserResetToken(IUserResetPasswordDB userResetPasswordDB, User user);
	public User findUserByResetToken(IUserResetPasswordDB userResetPasswordDB, String resetToken);
	public void saveUserPassword(IUserResetPasswordDB userResetPasswordDB, User user);
	
}

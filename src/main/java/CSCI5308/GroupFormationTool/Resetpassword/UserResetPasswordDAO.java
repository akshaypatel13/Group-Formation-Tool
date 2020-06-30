package CSCI5308.GroupFormationTool.Resetpassword;

import CSCI5308.GroupFormationTool.AccessControl.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserResetPasswordDAO implements IUserResetPasswordDAO {


	@Override
	public void saveUserResetToken(IUserResetPasswordDB userResetPasswordDB, User user)
	{
		userResetPasswordDB.saveUserResetToken(user);
	}

	@Override
	public User findUserByResetToken(IUserResetPasswordDB userResetPasswordDB, String resetToken)
	{
		return userResetPasswordDB.findUserByResetToken(resetToken);
	}

	@Override
	public void saveUserPassword(IUserResetPasswordDB userResetPasswordDB, User user)
	{
		userResetPasswordDB.saveUserPassword(user);
	}

}

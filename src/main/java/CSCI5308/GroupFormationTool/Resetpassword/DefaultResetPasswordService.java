package CSCI5308.GroupFormationTool.Resetpassword;


import CSCI5308.GroupFormationTool.AccessControl.User;
import org.springframework.stereotype.Service;

@Service
public class DefaultResetPasswordService implements IResetPasswordService {

	private IUserResetPasswordDAO userResetPasswordDAO;
	private IUserResetPasswordDB userResetPasswordDB;
	
	public DefaultResetPasswordService(IUserResetPasswordDAO userResetPasswordDAO,
									   IUserResetPasswordDB userResetPasswordDB)
	{
		this.userResetPasswordDAO = userResetPasswordDAO;
		this.userResetPasswordDB = userResetPasswordDB;
	}


	@Override
	public void saveUserResetToken(User user)
	{
		userResetPasswordDAO.saveUserResetToken(userResetPasswordDB, user);
	}

	@Override
	public User findUserByResetToken(String resetToken)
	{
		User user = userResetPasswordDAO.findUserByResetToken(userResetPasswordDB, resetToken);
		return user;
	}

	@Override
	public void saveUserPassword(User user)
	{
		userResetPasswordDAO.saveUserPassword(userResetPasswordDB, user);
	}

}

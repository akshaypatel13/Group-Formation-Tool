package CSCI5308.GroupFormationTool.Resetpassword;


import CSCI5308.GroupFormationTool.AccessControl.User;
import CSCI5308.GroupFormationTool.PasswordPolicy.IPasswordPolicyList;
import CSCI5308.GroupFormationTool.PasswordPolicy.IPasswordPolicyValidator;
import CSCI5308.GroupFormationTool.PasswordPolicy.PasswordPolicy;
import CSCI5308.GroupFormationTool.SystemConfig;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

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
	public void setUserResetToken(User user) {
		String resetToken = UUID.randomUUID().toString().replace("-", "");
		user.setResetToken(resetToken);
	}


	@Override
	public void saveUserPassword(User user)
	{
		userResetPasswordDAO.saveUserPassword(userResetPasswordDB, user);
	}

	@Override
	public boolean checkPasswordPolicies(User user, String rawPassword)
	{
		IPasswordPolicyList passwordPolicyList = SystemConfig.instance().getIPasswordPolicyList();
		ArrayList<PasswordPolicy> policies = passwordPolicyList.getAllPasswordPolicies();
		boolean success = true;
		for(PasswordPolicy policy: policies) {
			if(Integer.parseInt(policy.getEnabled()) == 1) {
				IPasswordPolicyValidator validator = policy.getValidator();
				if(validator.isPasswordValid(rawPassword) == false) {
					success = false;
					break;
				}
			}
		}
		return success;
	}

}

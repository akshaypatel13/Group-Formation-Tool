package CSCI5308.GroupFormationTool.PasswordValidation;

import java.util.List;

import CSCI5308.GroupFormationTool.AccessControl.IUser;
import CSCI5308.GroupFormationTool.AccessControl.User;

public interface IPasswordValidatorEnumerator 
{
	public List<PasswordValidator> getActiveValidators(IUser user);
}

package CSCI5308.GroupFormationTool.PasswordPolicy;

import CSCI5308.GroupFormationTool.AccessControl.User;

import java.util.ArrayList;

public interface IPasswordPolicyList
{
	public ArrayList<PasswordPolicy> getAllPasswordPolicies(User user);
}

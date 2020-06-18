package CSCI5308.GroupFormationTool.Security;

import CSCI5308.GroupFormationTool.AccessControl.User;

public interface IPasswordSecurityPolicy {
	
	public String isFollowingSecurityRules(String password);
	public boolean checkPreviousPassword(User U);

}

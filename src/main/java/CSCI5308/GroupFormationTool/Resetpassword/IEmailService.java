package CSCI5308.GroupFormationTool.Resetpassword;

import CSCI5308.GroupFormationTool.AccessControl.User;

import javax.servlet.http.HttpServletRequest;

public interface IEmailService
{
	public void sendEmail(User user, HttpServletRequest request);
}

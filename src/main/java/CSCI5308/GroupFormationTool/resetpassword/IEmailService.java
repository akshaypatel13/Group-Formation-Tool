package CSCI5308.GroupFormationTool.resetpassword;

import CSCI5308.GroupFormationTool.AccessControl.User;
import org.springframework.mail.SimpleMailMessage;

import javax.servlet.http.HttpServletRequest;

public interface IEmailService {
	public void sendEmail(User user, HttpServletRequest request);
}

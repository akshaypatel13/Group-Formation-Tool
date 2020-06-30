package CSCI5308.GroupFormationTool.Resetpassword;

import CSCI5308.GroupFormationTool.AccessControl.DefaultJavaMailSender;
import CSCI5308.GroupFormationTool.AccessControl.User;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;

import javax.servlet.http.HttpServletRequest;


public class DefaultEmailService implements IEmailService {

	DefaultJavaMailSender javaMailSender = new DefaultJavaMailSender();
	JavaMailSender mailSender = javaMailSender.getJavaMailSender();

	@Async
	public void sendEmail(User user, HttpServletRequest request) {
		String appUrl = request.getScheme() + "://" + request.getServerName();
		SimpleMailMessage resetPasswordEmail = new SimpleMailMessage();
		resetPasswordEmail.setFrom("support@group21.com");
		resetPasswordEmail.setTo(user.getEmail());
		resetPasswordEmail.setSubject("Password Reset Request");
		resetPasswordEmail.setText("To reset your password, click the link below:\n" + appUrl + "/reset_token/" + user.getResetToken());
		mailSender.send(resetPasswordEmail);
	}

}

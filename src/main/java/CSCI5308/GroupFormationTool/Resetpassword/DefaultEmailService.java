package CSCI5308.GroupFormationTool.Resetpassword;

import CSCI5308.GroupFormationTool.AccessControl.User;
import CSCI5308.GroupFormationTool.SystemConfig;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Async;

import javax.servlet.http.HttpServletRequest;
import java.util.Properties;


public class DefaultEmailService implements IEmailService {


	private JavaMailSenderImpl setupMailSender(JavaMailSenderImpl mailSender) {

		mailSender.setHost(System.getenv("email_host"));
		mailSender.setUsername(System.getenv("email_username"));
		mailSender.setPassword(System.getenv("email_password"));
		mailSender.setPort(Integer.parseInt(System.getenv("email_port")));

		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "true");

		return mailSender;
	}

	@Async
	public void sendEmail(User user, HttpServletRequest request) {

		JavaMailSender mailSender = setupMailSender(SystemConfig.instance().getJavaMailSender());

		String appUrl = request.getScheme() + "://" + request.getServerName();
		SimpleMailMessage resetPasswordEmail = new SimpleMailMessage();
		resetPasswordEmail.setFrom("support@group21.com");
		resetPasswordEmail.setTo(user.getEmail());
		resetPasswordEmail.setSubject("Password Reset Request");
		resetPasswordEmail.setText("To reset your password, click the link below:\n" + appUrl + "/reset_token/" + user.getResetToken());
		mailSender.send(resetPasswordEmail);
	}

}

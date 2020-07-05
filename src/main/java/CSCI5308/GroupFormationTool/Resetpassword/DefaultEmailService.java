package CSCI5308.GroupFormationTool.Resetpassword;

import CSCI5308.GroupFormationTool.AccessControl.User;
import CSCI5308.GroupFormationTool.SystemConfig;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Async;

import javax.servlet.http.HttpServletRequest;
import java.util.Properties;


public class DefaultEmailService implements IEmailService
{

	private static final String emailHost = "email_host";
	private static final String emailUsername = "email_username";
	private static final String emailPassword = "email_password";
	private static final String emailPort = "email_port";
	private static final String emailUrl = "support@group21.com";
	private static final String emailSubject = "Password Reset Request";

	private JavaMailSenderImpl setupMailSender(JavaMailSenderImpl mailSender)
	{
		mailSender.setHost(System.getenv(emailHost));
		mailSender.setUsername(System.getenv(emailUsername));
		mailSender.setPassword(System.getenv(emailPassword));
		mailSender.setPort(Integer.parseInt(System.getenv(emailPort)));
		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "true");
		return mailSender;
	}

	@Async
	public void sendEmail(User user, HttpServletRequest request)
	{
		JavaMailSender mailSender = setupMailSender(SystemConfig.instance().getJavaMailSender());
		String appUrl = request.getScheme() + "://" + request.getServerName();
		SimpleMailMessage resetPasswordEmail = new SimpleMailMessage();
		resetPasswordEmail.setFrom(emailUrl);
		resetPasswordEmail.setTo(user.getEmail());
		resetPasswordEmail.setSubject(emailSubject);
		resetPasswordEmail.setText("To reset your password, click the link below:\n" + appUrl + "/reset_token/" + user.getResetToken());
		mailSender.send(resetPasswordEmail);
	}

}

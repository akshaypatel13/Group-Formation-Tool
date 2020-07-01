package CSCI5308.GroupFormationTool.AccessControl;

import CSCI5308.GroupFormationTool.SystemConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Properties;


public class UserNotifications implements IUserNotifications
{

    private JavaMailSenderImpl setupMailSender(JavaMailSenderImpl mailSender)
    {
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
    public void sendUserLoginCredentials(User user, String rawPassword)
    {
        JavaMailSender mailSender = setupMailSender(SystemConfig.instance().getJavaMailSender());
        SimpleMailMessage Email = new SimpleMailMessage();
        Email.setFrom("support@group21.com");
        Email.setTo(user.getEmail());
        System.out.print(user.getEmail());
        Email.setSubject("Account Credentials");
        Email.setText("You have been added to a Course\nPlease find your Login Credentials \nUsername: " + user.getBannerID() + "\nPassword: " + rawPassword);
        mailSender.send(Email);
    }

}

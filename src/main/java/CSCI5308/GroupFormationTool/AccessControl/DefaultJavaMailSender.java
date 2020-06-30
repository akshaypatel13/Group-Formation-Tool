package CSCI5308.GroupFormationTool.AccessControl;

import CSCI5308.GroupFormationTool.SystemConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;


public class DefaultJavaMailSender {

    public JavaMailSender getJavaMailSender()
    {
        JavaMailSenderImpl mailSender = SystemConfig.instance().getJavaMailSender();

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
}

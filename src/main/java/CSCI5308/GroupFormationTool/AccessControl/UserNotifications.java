package CSCI5308.GroupFormationTool.AccessControl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class UserNotifications implements IUserNotifications{
    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendUserLoginCredentials(User user, String rawPassword) {

        // Email message
        SimpleMailMessage Email = new SimpleMailMessage();
        Email.setFrom("support@group21.com");
        Email.setTo(user.getEmail());

        Email.setSubject("Account Credentials");
        Email.setText("You have been added to a Course\nPlease find your Login Credentials \nUsername: " + user.getBannerID() + "\nPassword: " + user.getPassword());

        mailSender.send(Email);

    }
}

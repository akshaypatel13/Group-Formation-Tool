package com.example.CATME.resetpassword;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.CATME.database.UserResetPasswordDBImpl;
import com.example.CATME.user.User;

@Controller
public class ResetPasswordController {
	
	private ResetPasswordService resetPasswordService;
	
	@Autowired
	private EmailServiceImpl emailServiceImpl;
	
	public ResetPasswordController() {
		resetPasswordService = new ResetPasswordServiceImpl(
				new UserResetPasswordDAOImpl(),
				new UserResetPasswordDBImpl());
	}
	
	@GetMapping("/resetPassword")
	public String resetPasswordGet() {
		return "resetPassword";
	}
	
	@PostMapping("/resetPassword")
	public String resetPasswordPost(@RequestParam("email") String email,
			HttpServletRequest request,
			Model theModel) {
		
		// look up user in database by email
		User user = resetPasswordService.findUserByEmail(email);
		if(user == null) {
			theModel.addAttribute("message", "We didn't find an account for that e-mail address.");
		}else {
			theModel.addAttribute("message", "Reset password email has been sent.");
			
			// generate uuid used as reset_token
			user.setResetToken(UUID.randomUUID().toString().replace("-", ""));
			resetPasswordService.saveUserResetToken(user);
			
			String appUrl = request.getScheme() + "://" + request.getServerName();
			
			// Email message
			SimpleMailMessage resetPasswordEmail = new SimpleMailMessage();
			resetPasswordEmail.setFrom("support@group21.com");
			resetPasswordEmail.setTo(user.getEmail());
			resetPasswordEmail.setSubject("Password Reset Request");
			
			resetPasswordEmail.setText("To reset your password, click the link below:\n" + appUrl + "/reset_token/" + user.getResetToken());
			
			emailServiceImpl.sendEmail(resetPasswordEmail);
		}
		
		return "messageDisplay";
	}
	
	@GetMapping("/reset_token/{param}")
	public String confirmPasswordGet(@PathVariable("param") String resetToken, Model theModel) {
		theModel.addAttribute("resetToken", resetToken);
		return "confirmPassword";
	}
	
	@PostMapping("/reset_token/{param}")
	public String confirmPasswordPost(@PathVariable("param") String resetToken, 
			@RequestParam("password") String password,
			Model theModel) {
		
		System.out.println(resetToken);
		User user = resetPasswordService.findUserByResetToken(resetToken);

		if(user!=null) {
			user.setPassword(password);
			resetPasswordService.saveUserPassword(user);
			theModel.addAttribute("message", "Password reset success!");
		}else {
			theModel.addAttribute("message", "Invalid Reset Token");
		}
		
		return "messageDisplay";
	}
	
}

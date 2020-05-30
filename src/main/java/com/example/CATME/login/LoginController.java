package com.example.CATME.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.CATME.database.UserMySqlDB;
import com.example.CATME.user.User;
import com.example.CATME.user.UserLoginDAOImpl;

/**
 * LoginController class.
 * @author Ruize Nie
 * @version 1.0
 */
@Controller
public class LoginController {
	
	private LoginService loginServeice;
	
	@GetMapping("/login")
	public String loginGet() {
		return "login";
	}
	
	@PostMapping("/login")
	public String loginPost(@RequestParam("email") String email,
			@RequestParam("password") String password,
			Model theModel) {
		loginServeice = new LoginServiceImpl(new UserLoginDAOImpl(), new UserMySqlDB());
		User u = loginServeice.findUserByEmail(email);
		if(u==null) {
			theModel.addAttribute("message", "This Email Doesn't Exist!");
			return "messageDisplay";
		}
		return "homePage";
	}
}

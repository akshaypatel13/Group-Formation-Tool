package com.example.CATME.login;

import com.example.CATME.signup.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestParam;

import com.example.CATME.database.UserLogInDBImpl;
import com.example.CATME.user.User;

/**
 * LoginController class.
 * @author Ruize Nie
 * @version 1.0
 */
@Controller
public class LoginController {

	@GetMapping("/login")
	public String login() {
		return "login";
	}


}

package com.example.CATME.signup;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.example.CATME.user.User;

public interface SignUpController {

	public String signup(Model model);

	// public String signupSubmit(@ModelAttribute User user);
	public String signupSubmit(User user, BindingResult bindingresult);

}

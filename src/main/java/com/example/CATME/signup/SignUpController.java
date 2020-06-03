package com.example.CATME.signup;

import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.example.CATME.user.User;

public interface SignUpController {

	public String signup(Model model);


	String signupSubmit(@Valid User user, BindingResult bindingresult, Model model);

}

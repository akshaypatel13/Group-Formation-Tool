package com.example.CATME.signup;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import javax.validation.Valid;

public interface SignUpController {
	
	public String signup(Model model);
	//public String signupSubmit(@ModelAttribute User user);
	public String signupSubmit(@Valid User user, BindingResult bindingresult) ;

}

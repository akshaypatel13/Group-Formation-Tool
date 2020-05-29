package com.example.CATME.signup;

import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

public interface SignUpController {
	
	public String signup(Model model);
	//public String signupSubmit(@ModelAttribute User user);
	public String signupSubmit(@Valid User user, BindingResult bindingresult) ;

}

package com.example.CATME.signup;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

public interface SignUpController {
	
	public String signup(Model model);
	//public String signupSubmit(@ModelAttribute User user);

}

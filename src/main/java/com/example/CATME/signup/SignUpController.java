package com.example.CATME.signup;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;




@Controller
public class SignUpController {
	UserService userService =new UserServiceImpl();

	
	@GetMapping("/signup")
	public String signup(Model model) {
		
		model.addAttribute("user", new User());
		return "signup";
	}
	
	 @PostMapping("/signup")
	  public String signupSubmit(@ModelAttribute User  user) {
	    userService.register(user);
	    return "result";
	  }
	
	

}

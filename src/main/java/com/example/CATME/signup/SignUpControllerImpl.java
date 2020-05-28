package com.example.CATME.signup;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignUpControllerImpl implements SignUpController{

	@Autowired
	UserService userService;

	@GetMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("user", new User());
		return "signup";
	}

	@PostMapping("/signup")
	public String signupSubmit(@Valid User user, BindingResult bindingresult) {
		if (bindingresult.hasErrors()) {
            return "signup";
		} else {
			userService.register(user);
			return "login";
		}
	}

}

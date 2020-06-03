package com.example.CATME.signup;


import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.CATME.database.UserSignUpDBImpl;
import com.example.CATME.user.User;

import javax.validation.Valid;

@Controller
public class SignUpControllerImpl implements SignUpController {

	UserSignUpService userService;

	public SignUpControllerImpl() {
		userService = new UserSignUpServiceImpl(new UserSignUpDAOImpl(), new UserSignUpDBImpl());

	}

	@Override
	@GetMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("user", new User());
		return "signup";
	}

	@Override
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

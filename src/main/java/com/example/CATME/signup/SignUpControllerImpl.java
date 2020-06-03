package com.example.CATME.signup;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.CATME.database.UserSignUpDBImpl;
import com.example.CATME.user.User;

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
	public String signupSubmit(@Valid User user, BindingResult bindingresult, Model model) {

		if (userService.findUserByEmail(user.getEmail())) {
			model.addAttribute("error", "Email already exists!");
			return "signup";
		}
		if (userService.findUserByBannerId(user.getBannerId())) {
			model.addAttribute("biderror", "BannerId already exists!");
			return "signup";
		}
		if (bindingresult.hasErrors()) {
			return "signup";
		} else {
			userService.register(user);
			return "login";
		}
	}

}

package com.example.CATME.signup;

import javax.validation.Valid;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

@SpringBootTest
public class SignUpControllerImplTest {

	@Test
     public String signup(Model model) {
		return null;

	}
	
	@Test
	public String signupSubmit(@Valid @ModelAttribute User user)
	{
		return null;
	}

}

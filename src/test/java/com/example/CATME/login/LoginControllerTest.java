package com.example.CATME.login;

import org.junit.Test;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import static org.junit.Assert.assertTrue;

/**
 * LoginControllerTest class for unit testing.
 * @author Ruize Nie
 * @version 1.0
 */
public class LoginControllerTest {
	
	private LoginController createDefaultLoginController()
	{
		return new LoginController();
	}
	
	@Test
	public void loginGetTest() {
		LoginController loginController= createDefaultLoginController();
		assertTrue(loginController.loginGet().equals("login"));
	}
	
	@Test
	public void loginGetPost() {
		LoginController loginController= createDefaultLoginController();
		final Model model = new ExtendedModelMap();
		assertTrue(loginController.loginPost("nimda@dal.ca", "admin", model).equals("messageDisplay"));
		assertTrue(loginController.loginPost("admin@dal.ca", "admin", model).equals("homePage"));
	}
}

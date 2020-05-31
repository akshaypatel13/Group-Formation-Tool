package com.example.CATME.resetpassword;

import static org.junit.Assert.assertTrue;
import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import com.example.CATME.user.User;

/**
 * LoginControllerTest class for unit testing.
 * @author Ruize Nie
 * @version 1.0
 */
public class ResetPasswordControllerTest {
	
	private ResetPasswordController createDefaultResetPasswordController()
	{
		return new ResetPasswordController();
	}
	
	@Test
	public void resetPasswordGetTest() {
		ResetPasswordController resetPasswordController = createDefaultResetPasswordController();
		assertTrue(resetPasswordController.resetPasswordGet().equals("resetPassword"));
	}
	
	@Test
	public void resetPasswordPostTest() {
		HttpServletRequest  mockedRequest = Mockito.mock(HttpServletRequest.class);
		ResetPasswordController resetPasswordController = createDefaultResetPasswordController();
		final Model model = new ExtendedModelMap();
		//assertTrue(resetPasswordController.resetPasswordPost("rz376775@dal.ca", mockedRequest, model).equals("messageDisplay"));
		
	}
	
	@Test
	public void confirmPasswordGetTest() {
		ResetPasswordController resetPasswordController = createDefaultResetPasswordController();
		final Model model = new ExtendedModelMap();
		assertTrue(resetPasswordController.confirmPasswordGet(null, model).equals("confirmPassword"));
	}
	
	@Test
	public void confirmPasswordGetPost() {
		ResetPasswordController resetPasswordController = createDefaultResetPasswordController();
		final Model model = new ExtendedModelMap();
		resetPasswordController.confirmPasswordPost(null, null, model).equals("messageDisplay");
	}
}

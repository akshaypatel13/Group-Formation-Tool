package com.example.CATME.signup;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class PasswordValidatorImpl implements ConstraintValidator<PasswordValidator, Object> {

	@Override
	public boolean isValid(final Object obj, ConstraintValidatorContext context) {
		User user = (User) obj;
		String password = user.getSetPassword();
		String confirmpassword = user.getConfirmPassword();

		if (password.equals(confirmpassword)) {
			return true;
		}

		return false;
	}

}
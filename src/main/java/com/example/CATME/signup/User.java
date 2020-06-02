package com.example.CATME.signup;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@PasswordValidator
@EmailValidator

public class User {

	
	@NotNull
	@NotEmpty
	private String firstname;
	
	@NotNull
	@NotEmpty
	private String lastname;
	
	@NotNull
	@NotEmpty
	private String bannerId;

	public String getBannerId() {
		return bannerId;
	}

	public void setBannerId(String bannerId) {
		this.bannerId = bannerId;
	}

	@NotNull
	@NotEmpty
	@Email
	
	private String email;
	
	@NotNull
    @NotEmpty
	private String setPassword;
	
	@NotNull
	@NotEmpty
	private String confirmPassword;

	public String getFirstname() {
		return firstname;
	}

	public String getSetPassword() {
		return setPassword;
	}

	public void setSetPassword(String setPassword) {
		this.setPassword = setPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}

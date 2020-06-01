package com.example.CATME.user;

/**
 * User Class for Initial the User object.
 * 
 * @author Ruize Nie
 * @version 1.0
 */
public class User {

	// Using the uuid as the user id
	private String userId;

	// banner id would be import from csv file
	private String bannerId;

	// the name can be given by user registration
	private String firstName;
	private String lastName;

	// the email & password from user registration
	private String email;
	private String password;

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	private String confirmPassword;

	// the reset token would be used when use forget password
	// the reset token will be generate by uuid
	private String resetToken;

	// field getter and setter method
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBannerId() {
		return bannerId;
	}

	public void setBannerId(String bannerId) {
		this.bannerId = bannerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getResetToken() {
		return resetToken;
	}

	public void setResetToken(String resetToken) {
		this.resetToken = resetToken;
	}

}
package com.example.CATME.signup;

public class UserMockData {
	
	public boolean register(User user) {
		user.setFirstname("Tom");
		user.setLastname("Johnson");
		user.setBannerId("B1111111");
		user.setEmail("abc@dal.ca");
		return true;
	}

}

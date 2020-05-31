package com.example.CATME.signup;

import com.example.CATME.user.User;

public class UserMockData {
	
	public boolean insertGuestUser(User user) {
		user.setFirstName("Tom");
		user.setLastName("Johnson");
		user.setBannerId("B1111111");
		user.setEmail("abc@dal.ca");
		return true;
	}

}

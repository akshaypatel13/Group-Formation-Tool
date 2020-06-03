package com.example.CATME.database;

import com.example.CATME.user.User;

public class UserSignUpMockDB {
	
	public boolean insertGuestUser(User user) {
		user.setFirstName("Tom");
		user.setLastName("Johnson");
		user.setBannerId("B1111111");
		user.setEmail("abc@dal.ca");
		return true;
	}


}

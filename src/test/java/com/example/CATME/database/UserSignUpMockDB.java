package com.example.CATME.database;

import com.example.CATME.user.User;

public class UserSignUpMockDB implements UserSignUpDB{
	
	@Override
	public void insertGuestUser(User user) {
		user.setFirstName("Tom");
		user.setLastName("Johnson");
		user.setBannerId("B1111111");
		user.setEmail("abc@dal.ca");
	}


	@Override
	public boolean findUserByEmail(String email) {
		if(email.equals("stu@gmail.com")) {
			return true;
		}
		return false;
	}

	@Override
	public boolean findUserByBannerId(String bannerId) {
		if(bannerId.equals("B01234567")) {
			return true;
		}
		return false;
	}


}

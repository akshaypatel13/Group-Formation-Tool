package com.example.CATME.instructor;


import com.example.CATME.signup.UserSignUpService;
import com.example.CATME.user.User;

public class UserServiceMock implements UserSignUpService {
    @Override
    public void register(User user) {
        user.setFirstName("Tom");
        user.setLastName("Johnson");
        user.setBannerId("B1111111");
        user.setEmail("abc@dal.ca");
    }

	@Override
	public boolean findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean findUserByBannerId(String bannerId) {
		// TODO Auto-generated method stub
		return false;
	}
}

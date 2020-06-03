package com.example.CATME.signup;

import com.example.CATME.user.User;

public interface UserSignUpService {

	void register(User user);
	public boolean findUserByEmail(String email);
	public boolean findUserByBannerId(String bannerId);

}

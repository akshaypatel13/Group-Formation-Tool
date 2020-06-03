package com.example.CATME.database;

import com.example.CATME.user.User;

public interface UserSignUpDB {

	public void insertGuestUser(User user);
	public boolean findUserByEmail(String email);
	boolean findUserByBannerId(String bannerId);

}

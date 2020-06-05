package com.example.CATME.database;

import com.example.CATME.user.User;

public interface UserSignUpDB {


	public boolean findUserByEmail(String email);
	boolean findUserByBannerId(String bannerId);

	public boolean insertGuestUser(User user);
	public boolean insertStudentUser(User user, int courseID);

}

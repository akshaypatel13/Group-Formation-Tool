package com.example.CATME.database;

import com.example.CATME.user.User;

public interface UserSignUpDB {

	public boolean insertGuestUser(User user);
	public boolean insertStudentUser(User user, int courseID);

}

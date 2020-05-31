package com.example.CATME.signup;

import com.example.CATME.database.UserSignUpDB;
import com.example.CATME.user.User;

//Repository
public class UserDAOImpl implements UserDAO {

	@Override
	public void register(UserSignUpDB UserSignUpDB, User user) {

		UserSignUpDB.insertGuestUser(user);

	}

}

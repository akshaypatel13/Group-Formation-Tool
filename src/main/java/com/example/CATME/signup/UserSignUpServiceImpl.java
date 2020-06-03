package com.example.CATME.signup;

import com.example.CATME.database.UserSignUpDB;
import com.example.CATME.user.User;

//Service
public class UserSignUpServiceImpl implements UserSignUpService {

	UserSignUpDAO UserDAO;
	UserSignUpDB UserSignUpDB;

	public UserSignUpServiceImpl(UserSignUpDAO UserDAO, UserSignUpDB UserSignUpDB) {
		this.UserDAO = UserDAO;
		this.UserSignUpDB = UserSignUpDB;
	}

	public void register(User user) {

		UserDAO.register(UserSignUpDB, user);
	}

}

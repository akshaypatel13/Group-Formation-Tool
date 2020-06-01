package com.example.CATME.signup;

import com.example.CATME.database.UserSignUpDB;
import com.example.CATME.user.User;

//Service
public class UserServiceImpl implements UserService {

	UserDAO UserDAO;
	UserSignUpDB UserSignUpDB;

	public UserServiceImpl(UserDAO UserDAO, UserSignUpDB UserSignUpDB) {
		this.UserDAO = UserDAO;
		this.UserSignUpDB = UserSignUpDB;
	}

	public void register(User user) {

		UserDAO.register(UserSignUpDB, user);
	}

}

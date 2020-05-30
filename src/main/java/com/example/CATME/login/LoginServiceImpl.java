package com.example.CATME.login;

import com.example.CATME.database.UserDB;
import com.example.CATME.user.User;
import com.example.CATME.user.UserLoginDAO;

public class LoginServiceImpl implements LoginService {

	private UserLoginDAO userLoginDAO;
	private UserDB userDB;
	
	public LoginServiceImpl(UserLoginDAO userLoginDAO, UserDB userDB) {
		this.userLoginDAO = userLoginDAO;
		this.userDB = userDB;
	}
	
	@Override
	public User findUserByEmail(String email) {
		return userLoginDAO.findUserByEmail(userDB, email);
	}

}

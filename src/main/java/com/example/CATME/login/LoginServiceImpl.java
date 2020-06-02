package com.example.CATME.login;

import org.springframework.stereotype.Service;

import com.example.CATME.database.UserLogInDB;
import com.example.CATME.user.User;

@Service
public class LoginServiceImpl implements LoginService {

	private UserLoginDAO userLoginDAO;
	private UserLogInDB userLogInDB;
	
	public LoginServiceImpl(UserLoginDAO userLoginDAO, UserLogInDB userLogInDB) {
		this.userLoginDAO = userLoginDAO;
		this.userLogInDB = userLogInDB;
	}
	
	@Override
	public User findUserByEmail(String email) {
		return userLoginDAO.findUserByEmail(userLogInDB, email);
	}

}

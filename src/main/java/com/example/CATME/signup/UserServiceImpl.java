package com.example.CATME.signup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;

	public void register(User user) {

		userDAO.register(user);
	}

}

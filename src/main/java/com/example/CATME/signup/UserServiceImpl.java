package com.example.CATME.signup;

public class UserServiceImpl implements UserService{
	
	UserDAO userDAO = new UserDAOImpl();
	public void register(User user) {
		System.out.println(user);
		userDAO.register(user);
	}

}

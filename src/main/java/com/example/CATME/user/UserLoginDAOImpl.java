package com.example.CATME.user;

import com.example.CATME.database.UserDB;

/**
 * UserLoginDAO implementation for user data access object.
 * @author Ruize Nie
 * @version 1.0
 */
public class UserLoginDAOImpl implements UserLoginDAO {

	@Override
	public User findUserByEmail(UserDB userDB, String email) {
		return userDB.findUserByEmail(email);
	}

}

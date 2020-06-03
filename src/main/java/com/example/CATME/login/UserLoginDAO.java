package com.example.CATME.login;

import com.example.CATME.database.UserLogInDB;
import com.example.CATME.user.User;

/**
 * UserLoginDAO Interface for user data access object.
 * @author Ruize Nie
 * @version 1.0
 */
public interface UserLoginDAO {
	public User findUserByEmail(UserLogInDB userLogInDB, String email);
}

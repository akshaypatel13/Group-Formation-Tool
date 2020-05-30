package com.example.CATME.user;

import com.example.CATME.database.UserDB;

/**
 * UserLoginDAO Interface for user data access object.
 * @author Ruize Nie
 * @version 1.0
 */
public interface UserLoginDAO {
	public User findUserByEmail(UserDB userDB, String email);
}

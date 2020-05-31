package com.example.CATME.database;

import com.example.CATME.user.User;

/**
 * UserDB Interface for load user database.
 * @author Ruize Nie
 * @version 1.0
 */
public interface UserLogInDB {
	public User findUserByEmail(String email);
}

package com.example.CATME.login;



import org.springframework.stereotype.Repository;

import com.example.CATME.database.UserLogInDB;
import com.example.CATME.user.User;

/**
 * UserLoginDAO implementation for user data access object.
 * @author Ruize Nie
 * @version 1.0
 */
@Repository
public class UserLoginDAOImpl implements UserLoginDAO {

	@Override
	public User findUserByEmail(UserLogInDB userLogInDB, String email) {
		return userLogInDB.findUserByEmail(email);
	}

}

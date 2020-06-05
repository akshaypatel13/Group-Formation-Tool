package com.example.CATME.signup;

import com.example.CATME.database.UserSignUpDB;
import com.example.CATME.user.User;

//Repository
public class UserSignUpDAOImpl implements UserSignUpDAO {

	@Override
	public void register(UserSignUpDB UserSignUpDB, User user) {

		UserSignUpDB.insertGuestUser(user);

	}

	@Override
	public boolean findUserByEmail(UserSignUpDB UserSignUpDB, String email) {
		return UserSignUpDB.findUserByEmail(email);
	}

	@Override
	public boolean findUserByBannerId(UserSignUpDB UserSignUpDB, String bannerId) {
		return UserSignUpDB.findUserByBannerId(bannerId);

	}

}

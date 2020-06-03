package com.example.CATME.signup;

import com.example.CATME.database.UserSignUpDB;
import com.example.CATME.user.User;

public interface UserSignUpDAO {

	public void register(UserSignUpDB UserSignUpDB, User user);

	public boolean findUserByEmail(UserSignUpDB UserSignUpDB, String email);

	public boolean findUserByBannerId(UserSignUpDB UserSignUpDB, String bannerId);


}

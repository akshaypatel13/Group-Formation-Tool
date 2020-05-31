package com.example.CATME.signup;

import com.example.CATME.database.UserSignUpDB;
import com.example.CATME.user.User;

public interface UserDAO {

	public void register(UserSignUpDB UserSignUpDB,User user);

}

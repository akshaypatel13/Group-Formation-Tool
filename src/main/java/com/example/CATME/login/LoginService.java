package com.example.CATME.login;

import com.example.CATME.user.User;

public interface LoginService {
	public User findUserByEmail(String email);
}

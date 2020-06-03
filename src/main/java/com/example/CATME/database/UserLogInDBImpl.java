package com.example.CATME.database;

import org.springframework.stereotype.Repository;

import com.example.CATME.user.User;

/**
 * UserMySqlDB implmentation mysql database.
 * using the MOCK data to do testing
 * @author Ruize Nie
 * @version 1.0
 */
@Repository
public class UserLogInDBImpl implements UserLogInDB{

	private MySQLOperationForUser mysql = new MySQLOperationForUser();

	@Override
	public User findUserByEmail(String email){
		String query = "SELECT * FROM user WHERE username = '" + email +"'";
		return mysql.findUser(query);
	}

}

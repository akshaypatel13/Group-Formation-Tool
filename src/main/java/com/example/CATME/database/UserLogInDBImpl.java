package com.example.CATME.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

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

	private MySQLConnection mysql = new MySQLConnection();

	@Override
	public User findUserByEmail(String email){
		String query = "SELECT * FROM USER WHERE email = '" + email +"'";
		return mysql.findUser(query);
	}

}

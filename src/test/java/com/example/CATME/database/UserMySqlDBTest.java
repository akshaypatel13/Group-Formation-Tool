package com.example.CATME.database;

import static org.junit.Assert.assertNotNull;

import java.sql.ResultSet;

import org.junit.Test;

import com.example.CATME.user.User;

/**
 * UserMySqlDBTest class for unit testing.
 * @author Ruize Nie
 * @version 1.0
 */
public class UserMySqlDBTest {
	
	private UserMySqlDB createDefaultMySqlDB()
	{
		return new UserMySqlDB();
	}
	
	@Test
	public void getDBConnectionTest() {
		UserMySqlDB userMySqlDB = createDefaultMySqlDB();
		assertNotNull(userMySqlDB.getDBConnection());
	}
	  
	@Test
	public void executeQueryTest() {
		UserMySqlDB userMySqlDB = createDefaultMySqlDB();
		ResultSet result = userMySqlDB.executeQuery("select * from USER");
		assertNotNull(result);
	}
	
	@Test
	public void findUserByEmailTest() {
		UserMySqlDB userMySqlDB = createDefaultMySqlDB();
		User u = userMySqlDB.findUserByEmail("admin@dal.ca");
		assertNotNull(u);
	}

}

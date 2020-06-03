package com.example.CATME.database;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.example.CATME.user.User;

public class MySQLOperationForUserTest {
	
	private MySQLOperationForUser createMySQLOperationForUser() {
		return new MySQLOperationForUser();
	}
	
	@Test
	public void findUserTest() {
		MySQLOperationForUser mySQLOperationForUser = createMySQLOperationForUser();
		User user = mySQLOperationForUser.findUser("select * from user where username = 'admin@gmail.com'");
		assertNotNull(user);
	}
	
	@Test
	public void updateQueryTest() {
		MySQLOperationForUser mySQLOperationForUser = createMySQLOperationForUser();
		int result = mySQLOperationForUser.updateUser(" UPDATE user SET first_name = 'admin' WHERE username = 'admin@gmail.com'");
		assertTrue(result != 0);
	}
}

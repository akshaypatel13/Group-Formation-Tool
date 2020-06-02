package com.example.CATME.database;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.sql.ResultSet;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;

import com.example.CATME.user.User;
/**
 * UserMySqlDBTest class for unit testing.
 * @author Ruize Nie
 * @version 1.0
 */
public class MySQLConnectionTest {

	private MySQLConnection createMySQLConnection() {
		return new MySQLConnection();
	}
	
	@Test
	public void getDBConnectionTest() throws Exception {
		MySQLConnection mySQLConnection = createMySQLConnection();
		assertNotNull(mySQLConnection.getConnection());

	}
	
	@Test
	public void findUserTest() {
		MySQLConnection mySQLConnection = createMySQLConnection();
		User user = mySQLConnection.findUser("select * from USER where email = 'admin@dal.ca'");
		assertNotNull(user);
	}
	
	@Test
	public void updateQueryTest() {
		MySQLConnection mySQLConnection = createMySQLConnection();
		int result = mySQLConnection.updateQuery(" UPDATE USER SET first_name = 'admin' WHERE email = 'admin@dal.ca'");
		assertTrue(result != 0);
	}
}

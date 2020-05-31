package com.example.CATME.database;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.sql.ResultSet;

import org.junit.Test;
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
	public void getDBConnectionTest() {
		MySQLConnection mySQLConnection = createMySQLConnection();
		assertNotNull(mySQLConnection.getDBConnection());
	}
	
	@Test
	public void executeQueryTest() {
		MySQLConnection mySQLConnection = createMySQLConnection();
		ResultSet result = mySQLConnection.selectQuery("select * from USER");
		assertNotNull(result);
	}
	
	@Test
	public void updateQueryTest() {
		MySQLConnection mySQLConnection = createMySQLConnection();
		int result = mySQLConnection.updateQuery(" UPDATE USER SET first_name = 'admin' WHERE email = 'admin@dal.ca'");
		assertTrue(result != 0);
	}
}

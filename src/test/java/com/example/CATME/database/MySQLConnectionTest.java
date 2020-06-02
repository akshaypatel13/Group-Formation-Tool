package com.example.CATME.database;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.Statement;

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
	public void getConnectionTest() throws Exception {
		MySQLConnection mySQLConnection = createMySQLConnection();
		Connection conn = mySQLConnection.getConnection();
		assertNotNull(conn);
		Statement st = conn.createStatement();
		mySQLConnection.closeConnection(conn, st);
	}
	
	@Test
	public void closeConnectionTest() throws Exception {
		MySQLConnection mySQLConnection = createMySQLConnection();
		Connection conn = mySQLConnection.getConnection();
		Statement st = conn.createStatement();
		mySQLConnection.closeConnection(conn, st);
		assertTrue(conn.isClosed());
	}

}

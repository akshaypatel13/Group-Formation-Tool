package com.example.CATME.database;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.example.CATME.user.User;

/**
 * UserMySqlDBTest class for unit testing.
 * @author Ruize Nie
 * @version 1.0
 */
public class UserLogInDBImplTest {
	
	private UserLogInDBImpl createDefaultMySqlDB()
	{
		return new UserLogInDBImpl();
	}
	  
	@Test
	public void findUserByEmailTest() {
		UserLogInDBImpl userLogInDBImpl = createDefaultMySqlDB();
		User u = userLogInDBImpl.findUserByEmail("admin@dal.ca");
		assertNotNull(u);
	}

}

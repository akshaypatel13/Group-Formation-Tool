package com.example.CATME.signup;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserDAOImplTest {
	@Autowired
	UserDAOImpl UserDAOImpl;
	
	@Test
	public void registerTest() 
	{
		UserDAOImpl = mock(UserDAOImpl.class);
		User user = new User();
		
		UserDAOImpl.register(user);

	    // Then
	    verify(UserDAOImpl).register(user); 
		
	}


}

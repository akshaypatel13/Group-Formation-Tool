package com.example.CATME.signup;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import org.springframework.boot.test.context.SpringBootTest;

import com.example.CATME.database.UserSignUpDBImpl;
import com.example.CATME.user.User;

@SpringBootTest
public class UserDAOImplTest {
	UserDAOImpl UserDAOImpl;
	UserSignUpDBImpl UserSignUpDBImpl;
	
	@Test
	public void registerTest() 
	{	
		
		UserDAOImpl = mock(UserDAOImpl.class);
		UserSignUpDBImpl = mock(UserSignUpDBImpl.class);
		User user = new User();
		
		UserDAOImpl.register(UserSignUpDBImpl, user);

	    // Then
	    verify(UserDAOImpl).register(UserSignUpDBImpl,user); 
		
	}


}

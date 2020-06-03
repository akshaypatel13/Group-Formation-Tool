package com.example.CATME.signup;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import org.springframework.boot.test.context.SpringBootTest;

import com.example.CATME.database.UserSignUpDBImpl;
import com.example.CATME.user.User;

@SpringBootTest
public class UserSignUpDAOImplTest {
	UserSignUpDAOImpl userDAOImpl;
	UserSignUpDBImpl userSignUpDBImpl;
	
	@Test
	public void registerTest() 
	{	
		
		userDAOImpl = mock(UserSignUpDAOImpl.class);
		userSignUpDBImpl = mock(UserSignUpDBImpl.class);
		User user = new User();
		
		userDAOImpl.register(userSignUpDBImpl, user);

	    // Then
	    verify(userDAOImpl).register(userSignUpDBImpl,user); 
		
	}


}

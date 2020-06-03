package com.example.CATME.signup;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.CATME.database.UserSignUpMockDB;
import com.example.CATME.user.User;

@SpringBootTest
public class UserSignUpServiceImplTest {
	
	UserSignUpServiceImpl UserServiceImpl;
	
	@Test
	public void registerTest()
	{
		UserSignUpMockDB userMock = new UserSignUpMockDB();
		User user = new User();
		
		assertEquals(true, userMock.insertGuestUser(user));
	
	}

}

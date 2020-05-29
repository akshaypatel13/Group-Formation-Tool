package com.example.CATME.signup;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceImplTest {
	
	@Autowired
	UserServiceImpl UserServiceImpl;
	
	@Test
	public void registerTest()
	{
		UserMockData userMock = new UserMockData();
		User user = new User();
		
		assertEquals(true, userMock.register(user));
	
	}

}

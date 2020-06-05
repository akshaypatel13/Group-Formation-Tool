package com.example.CATME.signup;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import org.springframework.boot.test.context.SpringBootTest;
import com.example.CATME.database.UserSignUpMockDB;
import com.example.CATME.user.User;

@SpringBootTest
public class UserSignUpDAOImplTest {
	UserSignUpDAOImpl UserSignUpDAOImpl;
	UserSignUpMockDB userMock = new UserSignUpMockDB();
	
	@Test
	public void registerTest() 
	{	
		User user = new User();

		userMock.insertGuestUser(user);
		
	}
	@Test
	public void findUserByEmailTest() {
		UserSignUpDAOImpl = mock(UserSignUpDAOImpl.class);
		
		when(UserSignUpDAOImpl.findUserByEmail(null, "abc@gmail.com"))
		.thenReturn(userMock.findUserByEmail("abc@gmail.com"));
		assertEquals(false, UserSignUpDAOImpl.findUserByEmail(null, "abc@gmail.com"));
		
		when(UserSignUpDAOImpl.findUserByEmail(null, "stu@gmail.com"))
		.thenReturn(userMock.findUserByEmail("stu@gmail.com"));
		assertEquals(true, UserSignUpDAOImpl.findUserByEmail(null, "stu@gmail.com"));
		
		
	}

	@Test
	public void findUserByBannerIdTest() {
		UserSignUpDAOImpl = mock(UserSignUpDAOImpl.class);
		
		when(UserSignUpDAOImpl.findUserByBannerId(null, "B0999999"))
		.thenReturn(userMock.findUserByBannerId("B0999999"));
		assertEquals(false, UserSignUpDAOImpl.findUserByBannerId(null, "B0999999"));
		
		when(UserSignUpDAOImpl.findUserByBannerId(null, "B01234567"))
		.thenReturn(userMock.findUserByBannerId("B01234567"));
		assertEquals(true, UserSignUpDAOImpl.findUserByBannerId(null, "B01234567"));;

	}


}

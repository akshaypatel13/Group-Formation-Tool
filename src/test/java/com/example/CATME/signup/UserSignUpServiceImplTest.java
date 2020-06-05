package com.example.CATME.signup;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.CATME.user.User;

@SpringBootTest
public class UserSignUpServiceImplTest {

	UserSignUpServiceImpl UserSignUpServiceImpl;

	@Test
	public void registerTest() {
		UserSignUpServiceImpl = mock(UserSignUpServiceImpl.class);
		User user = new User();
		
		UserSignUpServiceImpl.register( user);

	    // Then
	    verify(UserSignUpServiceImpl).register(user); 

	}

	@Test
	public void findUserByEmail() {
		UserSignUpServiceImpl = mock(UserSignUpServiceImpl.class);

		assertNotEquals(null, UserSignUpServiceImpl.findUserByEmail("mock@gmail.com"));
	}

	@Test
	public void findUserByBannerId() {
		UserSignUpServiceImpl = mock(UserSignUpServiceImpl.class);

		assertNotEquals(null, UserSignUpServiceImpl.findUserByBannerId("B0999999"));
	}

}

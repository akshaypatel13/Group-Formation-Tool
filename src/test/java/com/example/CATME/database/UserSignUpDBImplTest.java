package com.example.CATME.database;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import com.example.CATME.user.User;

public class UserSignUpDBImplTest {
	private UserSignUpDBImpl userSignUpDBImpl;
	UserSignUpMockDB mockDB = new UserSignUpMockDB();

	@Test
	public void insertGuestUser() {

		userSignUpDBImpl = mock(UserSignUpDBImpl.class);

		User user = new User();

		userSignUpDBImpl.insertGuestUser(user);

		// Then
		verify(userSignUpDBImpl).insertGuestUser(user);

	}

}

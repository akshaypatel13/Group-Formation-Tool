package com.example.CATME.landingPage;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;

import org.junit.Test;

public class LandingPageServiceImplTest {

	private LandingPageServiceImpl landingPageServiceImpl;

	@Test
	public void getAllCourses() {

		landingPageServiceImpl = mock(LandingPageServiceImpl.class);

		assertNotEquals(null, landingPageServiceImpl.getAllCourses());
	}

	@Test
	public void getStudentCourses() {

		landingPageServiceImpl = mock(LandingPageServiceImpl.class);

		assertNotEquals(null, landingPageServiceImpl.getStudentCourses("mock@gmail.com"));

	}

	@Test
	public void getTACourses() {
		landingPageServiceImpl = mock(LandingPageServiceImpl.class);

		assertNotEquals(null, landingPageServiceImpl.getTACourses("mock@gmail.com"));

	}

	@Test
	public void getInstructorCourses() {
		landingPageServiceImpl = mock(LandingPageServiceImpl.class);

		assertNotEquals(null, landingPageServiceImpl.getInstructorCourses("mock@gmail.com"));

	}

}

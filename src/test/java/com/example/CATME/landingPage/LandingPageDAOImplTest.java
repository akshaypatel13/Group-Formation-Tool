package com.example.CATME.landingPage;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.CATME.database.CoursesDB;
import com.example.CATME.database.CourseMockDB;

@SpringBootTest
public class LandingPageDAOImplTest {
	private LandingPageDAOImpl LandingPageDAOImpl;
	CourseMockDB mockDB = new CourseMockDB();

	@Test
	public void getAllCoursesTest() {
		LandingPageDAOImpl = mock(LandingPageDAOImpl.class);

		assertNotEquals(null, LandingPageDAOImpl.getAllCourses((CoursesDB) mockDB));
	}

	@Test
	public void getStudentCoursesTest() {
		LandingPageDAOImpl = mock(LandingPageDAOImpl.class);

		assertNotEquals(null, LandingPageDAOImpl.getStudentCourses("mock@gmail.com", (CoursesDB) mockDB));

	}

	@Test
	public void getTACoursesTest() {
		LandingPageDAOImpl = mock(LandingPageDAOImpl.class);

		assertNotEquals(null, LandingPageDAOImpl.getTACourses("mock@gmail.com", (CoursesDB) mockDB));
	}

	@Test
	public void getInstructorCoursesTest() {
		LandingPageDAOImpl = mock(LandingPageDAOImpl.class);

		assertNotEquals(null, LandingPageDAOImpl.getInstructorCourses("mock@gmail.com", (CoursesDB) mockDB));
	}

}

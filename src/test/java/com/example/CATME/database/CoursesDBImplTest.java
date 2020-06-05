package com.example.CATME.database;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CoursesDBImplTest {
	
	private CoursesDBImpl CoursesDBImpl;
	CourseMockDB mockDB = new CourseMockDB();
	
	@Test
	public void getAllCoursesTest() {
		CoursesDBImpl = mock(CoursesDBImpl.class);
		when(CoursesDBImpl.getAllCourses())
				.thenReturn(new ArrayList<ArrayList<String>>());
		assertEquals(0, CoursesDBImpl.getAllCourses().size());
		
		when(CoursesDBImpl.getAllCourses())
			.thenReturn(mockDB.getAllCourses());
		assertEquals(1, CoursesDBImpl.getAllCourses().size());
	}

	@Test
	public void getStudentCoursesTest() {
		CoursesDBImpl = mock(CoursesDBImpl.class);
		when(CoursesDBImpl.getStudentCourses("mock@gmail.com"))
				.thenReturn(new ArrayList<ArrayList<String>>());
		assertEquals(0, CoursesDBImpl.getStudentCourses("mock@gmail.com").size());
		
		when(CoursesDBImpl.getStudentCourses("mock@gmail.com"))
			.thenReturn(mockDB.getStudentCourses("mock@gmail.com"));
		assertEquals(1, CoursesDBImpl.getStudentCourses("mock@gmail.com").size());
		
	}

	@Test
	public void getTACoursesTest() {
		CoursesDBImpl = mock(CoursesDBImpl.class);
		when(CoursesDBImpl.getTACourses("mock@gmail.com"))
				.thenReturn(new ArrayList<ArrayList<String>>());
		assertEquals(0, CoursesDBImpl.getTACourses("mock@gmail.com").size());
		
		when(CoursesDBImpl.getTACourses("mock@gmail.com"))
			.thenReturn(mockDB.getTACourses("mock@gmail.com"));
		assertEquals(1, CoursesDBImpl.getTACourses("mock@gmail.com").size());
		
	}

	@Test
	public void getInstructorCoursesTest() {
		CoursesDBImpl = mock(CoursesDBImpl.class);
		when(CoursesDBImpl.getInstructorCourses("mock@gmail.com"))
				.thenReturn(new ArrayList<ArrayList<String>>());
		assertEquals(0, CoursesDBImpl.getInstructorCourses("mock@gmail.com").size());
		
		when(CoursesDBImpl.getInstructorCourses("mock@gmail.com"))
			.thenReturn(mockDB.getInstructorCourses("mock@gmail.com"));
		assertEquals(1, CoursesDBImpl.getInstructorCourses("mock@gmail.com").size());
	}

}

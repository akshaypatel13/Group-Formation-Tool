package com.example.CATME.landingPage;

import java.util.ArrayList;
import java.util.List;

import com.example.CATME.database.CoursesDB;

public class LandingPageDAOImpl implements LandingPageDAO {

	@Override
	public List<ArrayList<String>> getAllCourses(CoursesDB coursesDB) {
		return coursesDB.getAllCourses();
	}

	@Override
	public List<ArrayList<String>> getStudentCourses(String email, CoursesDB coursesDB) {
		return coursesDB.getStudentCourses(email);
	}

	@Override
	public List<ArrayList<String>> getTACourses(String email, CoursesDB coursesDB) {
		return coursesDB.getTACourses(email);
	}

	@Override
	public List<ArrayList<String>> getInstructorCourses(String email, CoursesDB coursesDB) {
		return coursesDB.getInstructorCourses(email);
	}

}

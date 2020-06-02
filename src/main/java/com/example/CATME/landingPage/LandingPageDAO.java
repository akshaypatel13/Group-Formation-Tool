package com.example.CATME.landingPage;

import java.util.ArrayList;
import java.util.List;

import com.example.CATME.database.CoursesDB;

public interface LandingPageDAO {
	public List<ArrayList<String>> getAllCourses(CoursesDB coursesDB);

	public List<ArrayList<String>> getStudentCourses(String email, CoursesDB coursesDB);

	public List<ArrayList<String>> getTACourses(String email, CoursesDB coursesDB);

	public List<ArrayList<String>> getInstructorCourses(String email, CoursesDB coursesDB);

}

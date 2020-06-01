package com.example.CATME.landingPage;

import java.util.ArrayList;
import java.util.List;

import com.example.CATME.database.CoursesDB;
import com.example.CATME.database.CoursesDBImpl;

public class LandingPageServiceImpl implements LandingPageService {

	LandingPageDAO landingPageDAO;
	CoursesDB coursesDB;

	public LandingPageServiceImpl(LandingPageDAO landingPageDAO, CoursesDB coursesDB) {
		this.landingPageDAO = landingPageDAO;
		this.coursesDB = coursesDB;
	}

	@Override
	public List<ArrayList<String>> getAllCourses() {
		return landingPageDAO.getAllCourses(coursesDB);
	}

	@Override
	public List<ArrayList<String>> getStudentCourses(String email) {
		return landingPageDAO.getStudentCourses(email, coursesDB);
	}

	@Override
	public List<ArrayList<String>> getTACourses(String email) {
		return landingPageDAO.getStudentCourses(email, coursesDB);
	}

}

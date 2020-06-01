package com.example.CATME.landingPage;

import java.util.ArrayList;
import java.util.List;

public interface LandingPageService {
	public List<ArrayList<String>> getAllCourses();

	public List<ArrayList<String>> getStudentCourses(String email);

	public List<ArrayList<String>> getTACourses(String email);

}

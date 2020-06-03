package com.example.CATME.database;

import java.util.ArrayList;
import java.util.List;

public interface CoursesDB {

	public List<ArrayList<String>> getAllCourses();

	public List<ArrayList<String>> getStudentCourses(String email);

	public List<ArrayList<String>> getTACourses(String email);

	public List<ArrayList<String>> getInstructorCourses(String email);

}

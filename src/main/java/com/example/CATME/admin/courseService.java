package com.example.CATME.admin;

import java.util.ArrayList;

public interface courseService {

	public ArrayList<courseModel> getCourses();
	
	public String deleteCourse(int course_id);
	
	public ArrayList<userModel> getUsers();
	
	public String insertCourse(String course_code,String course_name,String term,int year);
	
	public String insertInstructor(int course_id,String username);

	public userModel searchInstructor(String banner_id);
}

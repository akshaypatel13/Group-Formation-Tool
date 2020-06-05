package com.example.CATME.admin;

import java.util.ArrayList;

public interface courseDao {


	public ArrayList<courseModel> getAllCourses();
	
	public Boolean deleteCourses(int course_id);
	
	public ArrayList<userModel> getAllUsers();
	
	public Boolean addCourse(String course_code,String course_name,String term,int year);
	
	public Boolean addInstructor(String username,String authority,int course_id);

	public userModel searchByBannerID(String bannerid);
	
}

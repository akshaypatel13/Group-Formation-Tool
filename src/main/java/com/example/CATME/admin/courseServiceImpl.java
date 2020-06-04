package com.example.CATME.admin;

import java.util.ArrayList;
import java.util.UUID;


public class courseServiceImpl implements courseService {

	
	courseDaoImpl dao=new courseDaoImpl();
	
	@Override
	public ArrayList<courseModel> getCourses() {
		
		ArrayList<courseModel> courses=new ArrayList<courseModel>();
		try {
			courses=dao.getAllCourses();


		}catch(Exception e) {
			e.printStackTrace();
		}
		return courses;
	}

	@Override
	public String deleteCourse(int course_id) {
		Boolean result=dao.deleteCourses(course_id);
		String status="";
		if(result==true) {
			status="Course Deleted Successfully";
		}
		else {
			status="Course Not Deleted";
		}
		System.out.println(status);	
		return status;
		
	}

	@Override
	public ArrayList<userModel> getUsers() {
		
		ArrayList<userModel> users=new ArrayList<userModel>();
		try {
			users=dao.getAllUsers();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return users;
		
	}

	@Override
	public String insertCourse(String course_code,String course_name, String term, int year) {
		String status="";
		Boolean result=dao.addCourse(course_code,course_name, term, year);
		if(result==true) {
			status="Course Inserted Successfully";
		}else {
			status="Course Not Inserted";
		}
		return status;
	}



	@Override
	public String insertInstructor(int course_id, String username) {
		String status="";
		String authority="ROLE_INSTRUCTOR";

		Boolean result=dao.addInstructor(username,authority,course_id);
		if(result==true) {
			status="Instructor Inserted Successfully";
		}else {
			status="Instructor Not Inserted";
		}
		return status;
	}



	@Override
	public userModel searchInstructor(String banner_id) {
		userModel user=new userModel();
		user=dao.searchByBannerID(banner_id);
		return user;
	}


}

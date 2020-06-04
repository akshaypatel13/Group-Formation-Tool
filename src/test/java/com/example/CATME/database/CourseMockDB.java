package com.example.CATME.database;

import java.util.ArrayList;
import java.util.List;


public class CourseMockDB implements CoursesDB{


	private String courseId=null;
	private String courseName=null;
	private String courseTerm=null;
	private String year=null;
	
	public CourseMockDB() {
		this.courseId = "1";
		this.courseName = "Cloud";
		this.courseTerm = "Summer";
		this.year = "2020";
	}
	
	public List<ArrayList<String>> getAllCourses() {
		List<ArrayList<String>> courses = new ArrayList<ArrayList<String>>();
		ArrayList<String> cr = new ArrayList<String>();
		cr.add(this.courseId);
		cr.add(this.courseName);
		cr.add(this.courseTerm);
		cr.add(this.year);
		courses.add(cr);
		return courses;
	}

	
	public List<ArrayList<String>> getStudentCourses(String email) {
		List<ArrayList<String>> courses = new ArrayList<ArrayList<String>>();
		ArrayList<String> cr = new ArrayList<String>();
		cr.add(this.courseId);
		cr.add(this.courseName);
		cr.add(this.courseTerm);
		cr.add(this.year);
		courses.add(cr);
		return courses;
	}

	
	public List<ArrayList<String>> getTACourses(String email) {
		List<ArrayList<String>> courses = new ArrayList<ArrayList<String>>();
		ArrayList<String> cr = new ArrayList<String>();
		cr.add(this.courseId);
		cr.add(this.courseName);
		cr.add(this.courseTerm);
		cr.add(this.year);
		courses.add(cr);
		return courses;
	}

	
	public List<ArrayList<String>> getInstructorCourses(String email) {
		List<ArrayList<String>> courses = new ArrayList<ArrayList<String>>();
		ArrayList<String> cr = new ArrayList<String>();
		cr.add(this.courseId);
		cr.add(this.courseName);
		cr.add(this.courseTerm);
		cr.add(this.year);
		courses.add(cr);
		return courses;
	}
}

package com.example.CATME.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CoursesDBImpl implements CoursesDB {
	private MySQLConnection myConn = new MySQLConnection();

	@Override
	public List<ArrayList<String>> getAllCourses() {

		List<ArrayList<String>> courses = new ArrayList<ArrayList<String>>();

		String query = "SELECT * FROM COURSE";
		ResultSet myRs = myConn.selectQuery(query);
		try {
			while (myRs.next()) {
				ArrayList<String> course = new ArrayList<String>();
				course.add(myRs.getString(1));
				course.add(myRs.getString(2));
				course.add(myRs.getString(3));
				course.add(myRs.getString(4));
				courses.add(course);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(courses);
		return courses;
	}

	public List<ArrayList<String>> getStudentCourses(String email) {
		List<ArrayList<String>> courses = new ArrayList<ArrayList<String>>();

		String query = "with user_data as (Select course_id from ROLE where user_id = (select user_id from USER where email ='"
				+ email + " ' and role = 2 ))" + "select * from COURSE join user_data using (course_id);";
		ResultSet myRs = myConn.selectQuery(query);
		try {
			while (myRs.next()) {
				ArrayList<String> course = new ArrayList<String>();
				course.add(myRs.getString(1));
				course.add(myRs.getString(2));
				course.add(myRs.getString(3));
				course.add(myRs.getString(4));
				courses.add(course);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(courses);
		return courses;

	}

	public List<ArrayList<String>> getTACourses(String email) {
		List<ArrayList<String>> taCourses = new ArrayList<ArrayList<String>>();  
		// SQL query to fetch course data for given user email
		String query = "with user_data as (Select course_id from ROLE where user_id = (select user_id from USER where email ='"
				+ email + "' and role = 3))" + "select * from COURSE join user_data using (course_id);";
		ResultSet myRs = myConn.selectQuery(query);
		try {
			while (myRs.next()) {
				ArrayList<String> course = new ArrayList<String>();
				course.add(myRs.getString(1));
				course.add(myRs.getString(2));
				course.add(myRs.getString(3));
				course.add(myRs.getString(4));
			
				taCourses.add(course);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(taCourses);
		return taCourses;

	}

}

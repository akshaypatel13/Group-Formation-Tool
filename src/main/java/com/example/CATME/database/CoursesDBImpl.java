package com.example.CATME.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.CATME.user.User;

public class CoursesDBImpl implements CoursesDB {

	@Override
	public List<ArrayList<String>> getAllCourses() {

		List<ArrayList<String>> courses = new ArrayList<ArrayList<String>>();

		String query = "SELECT * FROM course";
		Connection conn = null;
		Statement st = null;
		try {
			// step 1: object connection from Mysql Connection util
			conn = MySQLConnection.getConnection();
			// step 2: create the statement to run the sql
			st = conn.createStatement();
			// step 3: run the sql
			ResultSet myRs = st.executeQuery(query);
			while (myRs.next()) {
				ArrayList<String> course = new ArrayList<String>();
				course.add(myRs.getString(3));
				course.add(myRs.getString(2));
				course.add(myRs.getString(4));
				course.add(myRs.getString(5));
				courses.add(course);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// step 6: close the connection
			MySQLConnection.closeConnection(conn, st);
		}

		return courses;
	}

	public List<ArrayList<String>> getStudentCourses(String email) {
		List<ArrayList<String>> courses = new ArrayList<ArrayList<String>>();
		Connection conn = null;
		Statement st = null;
		String query = "with course_data as (Select course_id from authorities where username= '" + email
				+ "' and authority = 'ROLE_STUDENT')" + "select * from course join course_data using (course_id);";
		try {
			// step 1: object connection from Mysql Connection util
			conn = MySQLConnection.getConnection();
			// step 2: create the statement to run the sql
			st = conn.createStatement();
			// step 3: run the sql
			ResultSet myRs = st.executeQuery(query);
			while (myRs.next()) {
				ArrayList<String> course = new ArrayList<String>();
				course.add(myRs.getString(3));
				course.add(myRs.getString(2));
				course.add(myRs.getString(4));
				course.add(myRs.getString(5));
				courses.add(course);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			// step 6: close the connection
			MySQLConnection.closeConnection(conn, st);
		}
		return courses;
	}

	public List<ArrayList<String>> getTACourses(String email) {
		List<ArrayList<String>> taCourses = new ArrayList<ArrayList<String>>();
		// SQL query to fetch course data for given user email
		String query = "with course_data as (Select course_id from authorities where username= '" + email
				+ "' and authority = 'ROLE_TA')" + "select * from course join course_data using (course_id);";
		Connection conn = null;
		Statement st = null;
		try {
			// step 1: object connection from Mysql Connection util
			conn = MySQLConnection.getConnection();
			// step 2: create the statement to run the sql
			st = conn.createStatement();
			// step 3: run the sql
			ResultSet myRs = st.executeQuery(query);
			while (myRs.next()) {
				ArrayList<String> course = new ArrayList<String>();
				course.add(myRs.getString(3));
				course.add(myRs.getString(2));
				course.add(myRs.getString(4));
				course.add(myRs.getString(5));
				course.add(myRs.getString("course_id"));
				taCourses.add(course);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			// step 6: close the connection
			MySQLConnection.closeConnection(conn, st);
		}

		return taCourses;

	}

	public List<ArrayList<String>> getInstructorCourses(String email) {
		List<ArrayList<String>> insCourses = new ArrayList<ArrayList<String>>();
		// SQL query to fetch course data for given user email
		String query = "with course_data as (Select course_id from authorities where username= '" + email + "'"
				+ "and authority = 'ROLE_INSTRUCTOR')" + "select * from course join course_data using (course_id);";
		Connection conn = null;
		Statement st = null;
		try {
			// step 1: object connection from Mysql Connection util
			conn = MySQLConnection.getConnection();
			// step 2: create the statement to run the sql
			st = conn.createStatement();
			// step 3: run the sql
			ResultSet myRs = st.executeQuery(query);
			while (myRs.next()) {
				ArrayList<String> course = new ArrayList<String>();

				course.add(myRs.getString(3));
				course.add(myRs.getString(2));
				course.add(myRs.getString(4));

				course.add(myRs.getString(5));
				course.add(myRs.getString("course_id"));

				insCourses.add(course);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			// step 6: close the connection
			MySQLConnection.closeConnection(conn, st);
		}

		return insCourses;
	}

	
}

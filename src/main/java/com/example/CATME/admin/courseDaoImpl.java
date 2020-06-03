package com.example.CATME.admin;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

import com.example.CATME.database.MySQLConnection;




public class courseDaoImpl implements courseDao{



	Connection connection;
	
	@Override
	public ArrayList<courseModel> getAllCourses() {
		
		ArrayList<courseModel> courses=new ArrayList<courseModel>();
		
		try {
			connection= MySQLConnection.getConnection();
			CallableStatement select=connection.prepareCall("{call getCourses()}");
			ResultSet rs=select.executeQuery();
			if(rs!=null) {
				while (rs.next()) {
					courseModel course = new courseModel();
					course.setCourse_id(rs.getInt(1));
					course.setCourse_code(rs.getString(2));
					course.setCourse_name(rs.getString(3));
					course.setTerm(rs.getString(4));
					course.setYear(rs.getInt(5));
					courses.add(course);

				}
			}else{
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				connection.close();
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}

		return courses;
		
	}

	@Override
	public Boolean deleteCourses(int course_id) {

		
		try {
			connection= MySQLConnection.getConnection();
			CallableStatement delete=connection.prepareCall("{call deleteCourses(?)}");
			delete.setInt(1,course_id);
			delete.execute();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			try {
				connection.close();
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}

	}

	@Override
	public ArrayList<userModel> getAllUsers() {
		ArrayList<userModel> users=new ArrayList<userModel>();
		
		try {
			connection= MySQLConnection.getConnection();
			CallableStatement select=connection.prepareCall("{call getUsers()}");
			ResultSet rs=select.executeQuery();
			
			while(rs.next()) {
				userModel user=new userModel();
				user.setUsername(rs.getString(1));
				user.setFirst_name(rs.getString(2));
				user.setLast_name(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setEnabled(rs.getInt(5));
				user.setBanner_id(rs.getString(6));
				user.setUser_id(rs.getString(7));
				users.add(user);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				connection.close();
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}
		return users;
		
	}



	@Override
	public Boolean addCourse( String course_code, String course_name, String term, int year) {
		try {
			connection= MySQLConnection.getConnection();
			CallableStatement insert=connection.prepareCall("{call insertCourse(?,?,?,?,?)}");
			insert.setInt(1,0);
			insert.setString(2,course_code);
			insert.setString(3, course_name);
			insert.setString(4, term);
			insert.setInt(5, year);
			insert.execute();

			return true;

		}catch(Exception e) {
			
			e.printStackTrace();
			return false;
		}finally{
			try {
				connection.close();
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}
	}

	@Override
	public Boolean addInstructor(String username, String authority,int course_id) {
		try {
			final String auth_id = UUID.randomUUID().toString().replace("-", "");
			connection= MySQLConnection.getConnection();
			CallableStatement insert=connection.prepareCall("{call addInstructor(?,?,?,?)}");
			insert.setString(1,username);
			insert.setString(2,authority);
			insert.setString(3,auth_id);
			insert.setInt(4,course_id);
			insert.execute();

			return true;

		}catch(Exception e) {

			e.printStackTrace();
			return false;

		}finally{
			try {
				connection.close();
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}
	}

	@Override
	public userModel searchByBannerID(String banner_id) {
		userModel user = new userModel();
		try {
			connection= MySQLConnection.getConnection();
			CallableStatement search = connection.prepareCall("{call searchInstructor(?)}");
			search.setString(1, banner_id);
			ResultSet rs = search.executeQuery();
			while (rs.next()) {

				user.setUsername(rs.getString(1));
				user.setFirst_name(rs.getString(2));
				user.setLast_name(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setEnabled(rs.getInt(5));
				user.setBanner_id(rs.getString(6));
				user.setUser_id(rs.getString(7));

			}
		} catch (Exception e) {
			return null;
		}finally{
			try {
				connection.close();
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}
		return user;
	}


}

package com.example.CATME.admin;

public class courseModel {
	
	private int course_id;
	private String course_code;
	private String course_name;
	private String term;
	private int year;

	public courseModel(int course_id, String course_code, String course_name, String term, int year) {

		this.course_id=course_id;
		this.course_code = course_code;
		this.course_name=course_name;
		this.term=term;
		this.year=year;

	}

	public courseModel() {

	}

	public String getCourse_code() {
		return course_code;
	}

	public void setCourse_code(String course_code) {
		this.course_code = course_code;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}




	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}

	
	
	
}

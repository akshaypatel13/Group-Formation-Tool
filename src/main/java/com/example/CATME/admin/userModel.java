package com.example.CATME.admin;

public class userModel {

	private String username;
	private String first_name;
	private String last_name;
	private String password;
	private int enabled;
	private String banner_id;
	private String user_id;

    public userModel(String username, String first_name, String last_name, String password, int enabled, String banner_id, String user_id) {
    	this.username=username;
    	this.first_name=first_name;
    	this.last_name=last_name;
    	this.password=password;
    	this.enabled=enabled;
    	this.banner_id=banner_id;
    	this.user_id=user_id;
    }

	public userModel() {

	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public String getBanner_id() {
		return banner_id;
	}

	public void setBanner_id(String banner_id) {
		this.banner_id = banner_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
}

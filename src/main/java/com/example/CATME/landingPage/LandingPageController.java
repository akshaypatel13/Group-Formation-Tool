package com.example.CATME.landingPage;

import org.springframework.ui.Model;

import javax.servlet.http.HttpServletResponse;

public interface LandingPageController {
	public String landingView(Model model, HttpServletResponse response);

	String courseView(String courseName, int courseId,  Model model);

}

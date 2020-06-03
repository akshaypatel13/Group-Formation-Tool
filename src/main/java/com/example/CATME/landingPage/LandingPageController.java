package com.example.CATME.landingPage;

import org.springframework.ui.Model;

public interface LandingPageController {
	public String landingView(Model model);

	String courseView(String courseName, Model model);

}

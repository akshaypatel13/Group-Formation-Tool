package com.example.CATME.landingPage;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.CATME.database.CoursesDBImpl;

@Controller
public class LandingPageControllerImpl implements LandingPageController {

	LandingPageService landingPageService;

	public LandingPageControllerImpl() {
		landingPageService = new LandingPageServiceImpl(new LandingPageDAOImpl(), new CoursesDBImpl());
	}

	String role = "ta";

	@Override
	@GetMapping("/")
	public String landingView(Model model) {
		if (role == "guest") {
			model.addAttribute("course", landingPageService.getAllCourses());
			return ("guest");
		}

		if (role == "student") {
			model.addAttribute("course", landingPageService.getStudentCourses("admin@dal.ca"));
			return ("guest");

		}

		if (role == "ta") {
			model.addAttribute("course", landingPageService.getStudentCourses("tm@dal.ca"));
			model.addAttribute("taCourse", landingPageService.getTACourses("tm@dal.ca"));
			return ("guest");

		}
		return null;
	}

}

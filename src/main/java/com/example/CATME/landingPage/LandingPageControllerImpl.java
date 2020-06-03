package com.example.CATME.landingPage;

import java.util.Set;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.CATME.database.CoursesDBImpl;

@Controller
public class LandingPageControllerImpl implements LandingPageController {

	LandingPageService landingPageService;

	public LandingPageControllerImpl() {
		landingPageService = new LandingPageServiceImpl(new LandingPageDAOImpl(), new CoursesDBImpl());
	}

	@Override
	@GetMapping("/")
	public String landingView(Model model) {
		Set<GrantedAuthority> userRole = null;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails user = (UserDetails) auth.getPrincipal();
		String userName = user.getUsername();
		System.out.println(userName);
		userRole = (Set<GrantedAuthority>) user.getAuthorities();
		System.out.println(userRole);

		if (userRole.contains(new SimpleGrantedAuthority("ROLE_INSTRUCTOR"))) {
			model.addAttribute("course", landingPageService.getInstructorCourses(userName));
			return ("instructor");
		} else if (userRole.contains(new SimpleGrantedAuthority("ROLE_TA"))) {
			model.addAttribute("course", landingPageService.getStudentCourses(userName));
			model.addAttribute("taCourse", landingPageService.getTACourses(userName));
			return ("ta");
		} else if (userRole.contains(new SimpleGrantedAuthority("ROLE_STUDENT"))) {
			model.addAttribute("course", landingPageService.getStudentCourses(userName));
			return ("student");
		} else {
			model.addAttribute("course", landingPageService.getAllCourses());
			return ("guest");
		}
	}

	@Override
	@GetMapping("/courseDetails")
	public String courseView(@RequestParam(value = "courseName") String courseName, Model model) {
		model.addAttribute("courseName", courseName);
		return "courseDetails";
	}

}

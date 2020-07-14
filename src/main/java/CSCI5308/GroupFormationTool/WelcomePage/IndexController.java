package CSCI5308.GroupFormationTool.WelcomePage;

import CSCI5308.GroupFormationTool.AccessControl.CurrentUser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

import CSCI5308.GroupFormationTool.SystemConfig;
import CSCI5308.GroupFormationTool.Courses.*;

@Controller
public class IndexController
{
	private static final Logger LOG = LogManager.getLogger(IndexController.class);

	@GetMapping("/")
	public String greeting(Model model)
	{
		LOG.info("Welcome to Group Formation Tool !!!! :- ");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication.isAuthenticated())
		{
			ICoursePersistence courseDB = CourseAbstractFactory.instance().createCourseDBInstance();
			List<Course> allCourses = courseDB.loadAllCourses();
			model.addAttribute("courses", allCourses);
		}
		return "index";
	}
}
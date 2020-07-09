package CSCI5308.GroupFormationTool.Courses;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import CSCI5308.GroupFormationTool.SystemConfig;
import CSCI5308.GroupFormationTool.Survey.ISurveyManagePersistence;

@Controller
public class CourseController
{
	private static final String ID = "id";
	private ISurveyManagePersistence surveyManageDB;
	private ICoursePersistence courseDB;
	
	public CourseController() 
	{
        surveyManageDB = SystemConfig.instance().getSurveyManageDB();
        courseDB = SystemConfig.instance().getCourseDB();
	}
	
	@GetMapping("/course/course")
	public String course(Model model, @RequestParam(name = ID) long courseID)
	{
		Course course = new Course();
		courseDB.loadCourseByID(courseID, course);
		boolean check = surveyManageDB.surveyPublishedOrNot(courseID);
		model.addAttribute("course", course);
		// This is likely something I would repeat elsewhere, I should come up with a generic solution
		// for this in milestone 2.
		List<Role> userRoles = course.getAllRolesForCurrentUserInCourse();
		if (null == userRoles)
		{
			// Default is user is a guest.
			model.addAttribute("instructor", false);
			model.addAttribute("ta", false);
			model.addAttribute("student", false);
			model.addAttribute("guest", true);
			model.addAttribute("survey", !check);
		}
		else
		{
			model.addAttribute("instructor", userRoles.contains(Role.INSTRUCTOR));
			model.addAttribute("ta", userRoles.contains(Role.TA));
			model.addAttribute("student", userRoles.contains(Role.STUDENT));
			model.addAttribute("guest", userRoles.isEmpty());
			model.addAttribute("survey", !check);
		}
		return "course/course";
	}
}

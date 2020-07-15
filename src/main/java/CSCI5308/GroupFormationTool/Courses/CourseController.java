package CSCI5308.GroupFormationTool.Courses;

import java.util.List;

import CSCI5308.GroupFormationTool.AccessControl.CurrentUser;
import CSCI5308.GroupFormationTool.Survey.SurveyAbstractFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import CSCI5308.GroupFormationTool.Survey.ISurveyManagePersistence;

@Controller
public class CourseController
{
	private static final Logger LOG = LogManager.getLogger(CourseController.class);
	private static final String ID = "id";
	private ISurveyManagePersistence surveyManageDB;
	private ICoursePersistence courseDB;
	
	public CourseController() 
	{
        surveyManageDB = SurveyAbstractFactory.instance().createSurveyManageDBInstance();
		courseDB = CourseAbstractFactory.instance().createCourseDBInstance();
	}
	
	@GetMapping("/course/course")
	public String course(Model model, @RequestParam(name = ID) long courseID)
	{
		LOG.info("Username:-"+ CurrentUser.instance().getCurrentAuthenticatedUser().getFirstName()
		+ ", login = Success");
		ICourse course = CourseAbstractFactory.instance().createCourseInstance();
		boolean check = surveyManageDB.surveyPublishedOrNot(courseID);
		courseDB.loadCourseByID(courseID, course);
		model.addAttribute("course", course);
		List<Role> userRoles = course.getAllRolesForCurrentUserInCourse();
		if (null == userRoles)
		{
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

package CSCI5308.GroupFormationTool.Courses;

import java.util.Iterator;
import java.util.List;

import CSCI5308.GroupFormationTool.AccessControl.UserAbstractFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import CSCI5308.GroupFormationTool.AccessControl.IUser;

@Controller
public class CourseAdminController
{
	private static final Logger LOG = LogManager.getLogger(CourseAdminController.class);
	private static final String ID = "id";
	private static final String TITLE = "title";
	private static final String INSTRUCTOR = "instructor";
	private static ICoursePersistence courseDB;
	private static ICourseUserRelationshipPersistence courseUserRelationshipDB;

	public CourseAdminController(){
		courseDB = CourseAbstractFactory.instance().createCourseDBInstance();
		courseUserRelationshipDB = CourseAbstractFactory.instance().courseUserRelationshipDBInstance();
	}

	@GetMapping("/admin/course")
	public String course(Model model)
	{
		List<ICourse> allCourses = courseDB.loadAllCourses();

		model.addAttribute("courses", allCourses);
		return "admin/course";
	}
	
	@GetMapping("/admin/assigninstructor")
	public String assignInstructor(Model model, @RequestParam(name = ID) long courseID)
	{
		ICourse course = CourseAbstractFactory.instance().createCourseInstance();
		courseDB.loadCourseByID(courseID, course);
		model.addAttribute("course", course);
		List<IUser> allUsersNotCurrentlyInstructors = courseUserRelationshipDB.findAllUsersWithoutCourseRole(Role.INSTRUCTOR, courseID);
		model.addAttribute("users", allUsersNotCurrentlyInstructors);
		return "admin/assigninstructor";
	}
	
	@GetMapping("/admin/deletecourse")
	public ModelAndView deleteCourse(@RequestParam(name = ID) long courseID)
	{
		ICourse course = CourseAbstractFactory.instance().createCourseInstance();
		course.setId(courseID);
		course.delete(courseDB);
		LOG.info("Course Deleted :" + courseID);
		ModelAndView mav = new ModelAndView("redirect:/admin/course");
		return mav;
	}

	@RequestMapping(value = "/admin/createcourse", method = RequestMethod.POST) 
	public ModelAndView createCourse(@RequestParam(name = TITLE) String title)
	{
		ICourse course = CourseAbstractFactory.instance().createCourseInstance();
		course.setTitle(title);
		course.createCourse(courseDB);
		LOG.info("Course Created :" + title);
		ModelAndView mav = new ModelAndView("redirect:/admin/course");
		return mav;
	}
	
	@RequestMapping(value = "/admin/assigninstructor", method = RequestMethod.POST) 
	public ModelAndView assignInstructorToCourse(@RequestParam(name = INSTRUCTOR) List<Integer> instructor,
		   @RequestParam(name = ID) long courseID)
	{
		ICourse course = CourseAbstractFactory.instance().createCourseInstance();
		course.setId(courseID);
		Iterator<Integer> iter = instructor.iterator();
		while (iter.hasNext())
		{
			IUser u = UserAbstractFactory.instance().createUserInstance();
			u.setId(iter.next().longValue());
			courseUserRelationshipDB.enrollUser(course, u, Role.INSTRUCTOR);
		}
		LOG.info("Instructor Assigned:"+ instructor+ "for Course: "+ courseID);
		ModelAndView mav = new ModelAndView("redirect:/admin/course");
		return mav;
   }
	
}
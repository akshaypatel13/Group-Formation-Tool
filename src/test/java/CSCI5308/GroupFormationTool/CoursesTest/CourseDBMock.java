package CSCI5308.GroupFormationTool.CoursesTest;

import java.util.ArrayList;
import java.util.List;

import CSCI5308.GroupFormationTool.Courses.CourseAbstractFactory;
import CSCI5308.GroupFormationTool.Courses.ICourse;
import CSCI5308.GroupFormationTool.Courses.ICoursePersistence;

public class CourseDBMock implements ICoursePersistence {
	public List<ICourse> loadAllCourses() {
		List<ICourse> courseList = new ArrayList<>();
		ICourse course = CourseAbstractFactory.instance().createCourseInstance();
		course.setId(0);
		course.setTitle("Software Engineering");
		courseList.add(course);
		ICourse courses = CourseAbstractFactory.instance().createCourseInstance();
		courses.setId(1);
		courses.setTitle("Advanced Topics in Software Development");
		courseList.add(courses);
		return courseList;
	}

	public void loadCourseByID(long id, ICourse course) {
		course.setId(id);
		course.setTitle("Software Engineering");
	}

	public boolean createCourse(ICourse course) {
		course.setId(0);
		course.setTitle("Software Engineering");
		return true;
	}

	public boolean deleteCourse(long id) {
		ICourse course = CourseAbstractFactory.instance().createCourseInstance();
		course.setId(id);
		course.setTitle("Software Engineering");
		course.setDefaults();
		return true;
	}
}

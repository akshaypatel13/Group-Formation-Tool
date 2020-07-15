package CSCI5308.GroupFormationTool.CoursesTest;

import CSCI5308.GroupFormationTool.Courses.CourseAbstractFactory;
import CSCI5308.GroupFormationTool.Courses.ICourse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import CSCI5308.GroupFormationTool.Courses.Course;
import CSCI5308.GroupFormationTool.Courses.ICoursePersistence;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@SuppressWarnings("deprecation")
class CourseTest 
{
	@Test
	public void ConstructorTests() 
	{
		ICourse course = CourseAbstractFactory.instance().createCourseInstance();
		Assert.isTrue(course.getId() == -1);
		Assert.isTrue(course.getTitle().isEmpty());
	}

	@Test
	public void setIdTest() 
	{
		ICourse course = CourseAbstractFactory.instance().createCourseInstance();
		course.setId(7);
		Assert.isTrue(course.getId() == 7);
	}

	@Test
	public void getIdTest() 
	{
		ICourse course = CourseAbstractFactory.instance().createCourseInstance();
		course.setId(7);
		Assert.isTrue(course.getId() == 7);
	}

	@Test
	public void setTitleTest() 
	{
		ICourse course = CourseAbstractFactory.instance().createCourseInstance();
		course.setTitle("Advanced Topics in Software Development");
		Assert.isTrue(course.getTitle().equals("Advanced Topics in Software Development"));
	}

	@Test
	public void getTitleTest() 
	{
		ICourse course = CourseAbstractFactory.instance().createCourseInstance();
		course.setTitle("Advanced Topics in Software Development");
		Assert.isTrue(course.getTitle().equals("Advanced Topics in Software Development"));
	}

	@Test
	public void deleteCourseTest() 
	{
		ICourseDBMock courseDB = CourseAbstractFactoryTest.instance().getCourseDBMock();
		boolean status = courseDB.deleteCourseTest(0);
		Assert.isTrue(status);
	}

	@Test
	public void createCourseTest() 
	{
		ICourseDBMock courseDB = CourseAbstractFactoryTest.instance().getCourseDBMock();
		ICourse course = CourseAbstractFactory.instance().createCourseInstance();
		course.setId(0);
		course.setTitle("Software Engineering");
		courseDB.createCourseTest(course);
		Assert.isTrue(course.getId() == 0);
		Assert.isTrue(course.getTitle().equals("Software Engineering"));
	}

}

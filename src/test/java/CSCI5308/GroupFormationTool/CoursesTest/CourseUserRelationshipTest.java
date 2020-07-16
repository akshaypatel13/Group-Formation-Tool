package CSCI5308.GroupFormationTool.CoursesTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import CSCI5308.GroupFormationTool.AccessControl.IUser;
import CSCI5308.GroupFormationTool.AccessControlTest.UserAbstractFactoryMock;
import CSCI5308.GroupFormationTool.Courses.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import CSCI5308.GroupFormationTool.AccessControlTest.CurrentUserMock;

@SpringBootTest
@SuppressWarnings("deprecation")
class CourseUserRelationshipTest 
{
	private ICourseUserRelationshipPersistence courseUserRelationshipDB;

	public CourseUserRelationshipTest()
	{
		courseUserRelationshipDB = CourseAbstractFactoryTest.instance().getCourseUserRelationshipPersistence();
	}

	@Test
	public void userHasRoleInCourse()
	{
		ICourse course = CourseAbstractFactory.instance().createCourseInstance();
		course.setId(0);
		CurrentUserMock currentUser = UserAbstractFactoryMock.instance().getCurrentUserMock();
		IUser user = currentUser.getCurrentAuthenticatedUser();
		List<Role> roles = courseUserRelationshipDB.loadUserRolesForCourse(course, user);
		assertThat(roles).isNotNull();
		assertThat(roles).isNotEmpty();
		Assert.isTrue(roles.size() > 0);
	}

	@Test
	public void loadAllRoluesForUserInCourse()
	{
		ICourse course = CourseAbstractFactory.instance().createCourseInstance();
		course.setId(0);
		CurrentUserMock currentUser = UserAbstractFactoryMock.instance().getCurrentUserMock();
		IUser user = currentUser.getCurrentAuthenticatedUser();
		List<Role> roles = courseUserRelationshipDB.loadUserRolesForCourse(course, user);
		Assert.isTrue(roles.size() > 0);
	}

	@Test
	public void enrollUserInCourse()
	{
		ICourse course = CourseAbstractFactory.instance().createCourseInstance();
		CurrentUserMock currentUser = UserAbstractFactoryMock.instance().getCurrentUserMock();
		IUser user = currentUser.getCurrentAuthenticatedUser();
		boolean result = courseUserRelationshipDB.enrollUser(course, user, Role.STUDENT);
		Assert.isTrue(result);
	}


}

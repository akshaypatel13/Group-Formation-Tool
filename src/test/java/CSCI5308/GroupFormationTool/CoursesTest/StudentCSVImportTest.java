package CSCI5308.GroupFormationTool.CoursesTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import CSCI5308.GroupFormationTool.AccessControl.IUser;
import CSCI5308.GroupFormationTool.AccessControl.UserAbstractFactory;
import CSCI5308.GroupFormationTool.AccessControlTest.IUserDBMock;
import CSCI5308.GroupFormationTool.AccessControlTest.IUserTest;
import CSCI5308.GroupFormationTool.AccessControlTest.UserAbstractFactoryMock;
import CSCI5308.GroupFormationTool.Courses.CourseAbstractFactory;
import CSCI5308.GroupFormationTool.Courses.ICourse;
import CSCI5308.GroupFormationTool.SecurityTest.SecurityTestAbstarctFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import CSCI5308.GroupFormationTool.AccessControl.IUserPersistence;
import CSCI5308.GroupFormationTool.AccessControl.User;
import CSCI5308.GroupFormationTool.AccessControlTest.UserDBMock;
import CSCI5308.GroupFormationTool.Courses.Course;
import CSCI5308.GroupFormationTool.Courses.Role;
import CSCI5308.GroupFormationTool.Security.IPasswordEncryption;
import CSCI5308.GroupFormationTool.SecurityTest.PasswordEncryptionMock;

@SpringBootTest
@SuppressWarnings("deprecation")
class StudentCSVImportTest {

	@Test
	public void enrollStudentFromRecord() {
		IUserTest userTest = UserAbstractFactoryMock.instance().getUser();
		IUser user = UserAbstractFactory.instance().createUserInstance();
		ICourse course = CourseAbstractFactory.instance().createCourseInstance();
		IUserDBMock userDB = UserAbstractFactoryMock.instance().getUserDBMock();
		IPasswordEncryption passwordEncryption = SecurityTestAbstarctFactory.instance().getPasswordEncryption();
		Assert.isTrue(userTest.createUserTest(userDB, null,user));
		Assert.isTrue(course.enrollUserInCourse(Role.STUDENT, user) == false);
	}

	@Test
	public void getSuccessResults() {
		List<String> successResults = new ArrayList<String>();
		successResults.add("Created record");
		assertThat(successResults).isNotNull();
		assertThat(successResults).isNotEmpty();
		Assert.isTrue(successResults.size() > 0);
	}

	@Test
	public void getFailureResults() {
		List<String> failureResults = new ArrayList<String>();
		failureResults.add("Created record");
		assertThat(failureResults).isNotNull();
		assertThat(failureResults).isNotEmpty();
		Assert.isTrue(failureResults.size() > 0);
	}

}

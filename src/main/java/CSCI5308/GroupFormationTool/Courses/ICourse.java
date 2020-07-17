package CSCI5308.GroupFormationTool.Courses;

import CSCI5308.GroupFormationTool.AccessControl.IUser;

import java.util.List;

public interface ICourse {

	public void setDefaults();

	public void setId(long id);

	public void setTitle(String title);

	public long getId();

	public String getTitle();

	public boolean delete(ICoursePersistence courseDB);

	public boolean createCourse(ICoursePersistence courseDB);

	public boolean enrollUserInCourse(Role role, IUser user);

	public boolean isCurrentUserEnrolledAsRoleInCourse(Role role);

	public boolean isCurrentUserEnrolledAsRoleInCourse(String role);

	public List<Role> getAllRolesForCurrentUserInCourse();

}

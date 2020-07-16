package CSCI5308.GroupFormationTool.Courses;

import java.util.List;

import CSCI5308.GroupFormationTool.AccessControl.*;

public class CourseUserRelationship implements ICourseUserRelationship {

	private ICourseUserRelationshipPersistence userCourseRelationshipDB;

	@Override
	public boolean userHasRoleInCourse(IUser user, Role role, ICourse course) {
		userCourseRelationshipDB = CourseAbstractFactory.instance().courseUserRelationshipDBInstance();
		if (null == user || user.isInValidUser()) {
			return false;
		}
		if (null == role) {
			return false;
		}
		if (null == course) {
			return false;
		}
		List<Role> roles = userCourseRelationshipDB.loadUserRolesForCourse(course, user);
		if (null != roles && roles.contains(role)) {
			return true;
		}
		return false;
	}

	@Override
	public List<Role> loadAllRoluesForUserInCourse(IUser user, ICourse course) {
		userCourseRelationshipDB = CourseAbstractFactory.instance().courseUserRelationshipDBInstance();
		List<Role> roles = userCourseRelationshipDB.loadUserRolesForCourse(course, user);
		return roles;
	}

	@Override
	public boolean enrollUserInCourse(IUser user, ICourse course, Role role) {
		userCourseRelationshipDB = CourseAbstractFactory.instance().courseUserRelationshipDBInstance();
		return userCourseRelationshipDB.enrollUser(course, user, role);
	}
}

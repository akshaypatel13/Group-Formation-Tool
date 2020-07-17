package CSCI5308.GroupFormationTool.Courses;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import CSCI5308.GroupFormationTool.AccessControl.*;

public class CourseUserRelationship implements ICourseUserRelationship {
	private static final Logger LOG = LogManager.getLogger();
	private ICourseUserRelationshipPersistence userCourseRelationshipDB;

	@Override
	public boolean userHasRoleInCourse(IUser user, Role role, ICourse course) {
		userCourseRelationshipDB = CourseAbstractFactory.instance().courseUserRelationshipDBInstance();
		if (null == user || user.isInValidUser()) {
			LOG.error("User is Invalid");
			return false;
		}
		if (null == role) {
			LOG.warn("Role object is empty");
			return false;
		}
		if (null == course) {
			LOG.warn("Course object is empty");
			return false;
		}
		List<Role> roles = userCourseRelationshipDB.loadUserRolesForCourse(course, user);
		if (null != roles && roles.contains(role)) {
			LOG.info("User has Role:" + role + " for the given Course");
			return true;
		}
		return false;
	}

	@Override
	public List<Role> loadAllRoluesForUserInCourse(IUser user, ICourse course) {
		LOG.info("Calling UserRelationShipDB to fetch all Roles of User for Course:" + course.getTitle());
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

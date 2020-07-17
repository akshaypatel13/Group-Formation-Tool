package CSCI5308.GroupFormationTool.Courses;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import CSCI5308.GroupFormationTool.AccessControl.UserAbstractFactory;
import CSCI5308.GroupFormationTool.AccessControl.IUser;
import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;
import CSCI5308.GroupFormationTool.Database.DatabaseAbstractFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CourseUserRelationshipDB implements ICourseUserRelationshipPersistence {
	private static final Logger LOG = LogManager.getLogger();

	@Override
	public List<IUser> findAllUsersWithoutCourseRole(Role role, long courseID) {
		List<IUser> users = new ArrayList<>();
		CallStoredProcedure proc = null;
		try {
			proc = DatabaseAbstractFactory.instance()
					.createCallStoredProcedureInstance("spFindUsersWithoutCourseRole(?, ?)");
			proc.setParameter(1, role.toString());
			proc.setParameter(2, courseID);
			ResultSet results = proc.executeWithResults();
			if (null != results) {
				while (results.next()) {
					long userID = results.getLong(1);
					String bannerID = results.getString(2);
					String firstName = results.getString(3);
					String lastName = results.getString(4);
					IUser u = UserAbstractFactory.instance().createUserInstance();
					u.setID(userID);
					u.setBannerID(bannerID);
					u.setFirstName(firstName);
					u.setLastName(lastName);
					users.add(u);
				}
				results.last();
				LOG.info("Operation = FindUsersWithoutCourseRole, Status = Success, RowCount=" + results.getRow());
			}
		} catch (SQLException e) {
			LOG.error("Status = Failed, Error Message=" + e.getMessage());
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		return users;
	}

	@Override
	public List<IUser> findAllUsersWithCourseRole(Role role, long courseID) {
		List<IUser> users = new ArrayList<>();
		CallStoredProcedure proc = null;
		try {
			proc = DatabaseAbstractFactory.instance()
					.createCallStoredProcedureInstance("spFindUsersWithCourseRole(?, ?)");
			proc.setParameter(1, role.toString());
			proc.setParameter(2, courseID);
			ResultSet results = proc.executeWithResults();
			if (null != results) {
				while (results.next()) {
					long userID = results.getLong(1);
					IUser u = UserAbstractFactory.instance().createUserInstance();
					u.setID(userID);
					users.add(u);
				}
				results.last();
				LOG.info("Operation = FindUsersWithCourseRole, Status = Success, RowCount=" + results.getRow());
			}
		} catch (SQLException e) {
			LOG.error("Status = Failed, Error Message=" + e.getMessage());
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		return users;
	}

	@Override
	public boolean enrollUser(ICourse course, IUser user, Role role) {
		CallStoredProcedure proc = null;
		try {
			proc = DatabaseAbstractFactory.instance().createCallStoredProcedureInstance("spEnrollUser(?, ?, ?)");
			proc.setParameter(1, course.getId());
			proc.setParameter(2, user.getID());
			proc.setParameter(3, role.toString());
			proc.execute();
		} catch (SQLException e) {
			LOG.error("Status = Failed, Error Message=" + e.getMessage());
			return false;
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		return true;
	}

	@Override
	public List<Role> loadUserRolesForCourse(ICourse course, IUser user) {
		List<Role> roles = new ArrayList<Role>();
		CallStoredProcedure proc = null;
		try {
			proc = DatabaseAbstractFactory.instance()
					.createCallStoredProcedureInstance("spLoadUserRolesForCourse(?, ?)");
			proc.setParameter(1, course.getId());
			proc.setParameter(2, user.getID());
			ResultSet results = proc.executeWithResults();
			if (null != results) {
				while (results.next()) {
					Role role = Role.valueOf(results.getString(1).toUpperCase());
					roles.add(role);
				}
				results.last();
				LOG.info("Operation = LoadUserRoleForCourse, Status = Success, RowCount=" + results.getRow());
			}
		} catch (SQLException e) {
			LOG.error("Status = Failed, Error Message=" + e.getMessage());
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		return roles;
	}
}

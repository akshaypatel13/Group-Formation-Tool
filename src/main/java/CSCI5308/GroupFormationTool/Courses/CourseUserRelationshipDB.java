package CSCI5308.GroupFormationTool.Courses;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import CSCI5308.GroupFormationTool.SystemConfig;
import CSCI5308.GroupFormationTool.AccessControl.IUser;
import CSCI5308.GroupFormationTool.AccessControl.IUserAbstractFactory;
import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;

public class CourseUserRelationshipDB implements ICourseUserRelationshipPersistence
{
	@Override
	public List<IUser> findAllUsersWithoutCourseRole(Role role, long courseID)
	{
		IUserAbstractFactory userAbstractFactory =SystemConfig.instance().getUserAbstractFactory();
		List<IUser> users =userAbstractFactory.createUserArrayList();
		CallStoredProcedure proc = null;
		try
		{
			proc = new CallStoredProcedure("spFindUsersWithoutCourseRole(?, ?)");
			proc.setParameter(1, role.toString());
			proc.setParameter(2,  courseID);
			ResultSet results = proc.executeWithResults();
			if (null != results)
			{
				while (results.next())
				{
					long userID = results.getLong(1);
					String bannerID = results.getString(2);
					String firstName = results.getString(3);
					String lastName = results.getString(4);
					IUser u =userAbstractFactory.createUserInstance();
					u.setID(userID);
					u.setBannerID(bannerID);
					u.setFirstName(firstName);
					u.setLastName(lastName);
					users.add(u);
				}
			}
		}
		catch (SQLException e)
		{
			// Logging needed.
		}
		finally
		{
			if (null != proc)
			{
				proc.cleanup();
			}
		}
		return users;
	}

	@Override
	public List<IUser> findAllUsersWithCourseRole(Role role, long courseID)
	{
		IUserAbstractFactory userAbstractFactory =SystemConfig.instance().getUserAbstractFactory();
		List<IUser> users =userAbstractFactory.createUserArrayList();
		CallStoredProcedure proc = null;
		try
		{
			proc = new CallStoredProcedure("spFindUsersWithCourseRole(?, ?)");
			proc.setParameter(1, role.toString());
			proc.setParameter(2,  courseID);
			ResultSet results = proc.executeWithResults();
			if (null != results)
			{
				while (results.next())
				{
					long userID = results.getLong(1);
					IUser u = userAbstractFactory.createUserInstance();
					u.setID(userID);
					users.add(u);
				}
			}
		}
		catch (SQLException e)
		{
			// Logging needed.
		}
		finally
		{
			if (null != proc)
			{
				proc.cleanup();
			}
		}
		return users;
	}
	
	@Override
	public boolean enrollUser(Course course, IUser user, Role role)
	{
		CallStoredProcedure proc = null;
		try
		{
			proc = new CallStoredProcedure("spEnrollUser(?, ?, ?)");
			proc.setParameter(1, course.getId());
			proc.setParameter(2, user.getID());
			proc.setParameter(3, role.toString());
			proc.execute();
		}
		catch (SQLException e)
		{
			// Logging needed
			return false;
		}
		finally
		{
			if (null != proc)
			{
				proc.cleanup();
			}
		}
		return true;
	}

	@Override
	public List<Role> loadUserRolesForCourse(Course course, IUser user)
	{
		List<Role> roles = new ArrayList<Role>();
		CallStoredProcedure proc = null;
		try
		{
			proc = new CallStoredProcedure("spLoadUserRolesForCourse(?, ?)");
			proc.setParameter(1, course.getId());
			proc.setParameter(2, user.getID());
			ResultSet results = proc.executeWithResults();
			if (null != results)
			{
				while (results.next())
				{
					Role role = Role.valueOf(results.getString(1).toUpperCase());
					roles.add(role);
				}
			}
		}
		catch (SQLException e)
		{
			// Logging needed.
		}
		finally
		{
			if (null != proc)
			{
				proc.cleanup();
			}
		}
		return roles;
	}
}

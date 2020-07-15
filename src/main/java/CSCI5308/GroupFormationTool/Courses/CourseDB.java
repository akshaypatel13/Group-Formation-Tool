package CSCI5308.GroupFormationTool.Courses;

import java.util.List;

import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;
import CSCI5308.GroupFormationTool.SystemConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CourseDB implements ICoursePersistence
{
	private static final Logger LOG = LogManager.getLogger();

	public List<Course> loadAllCourses()
	{
		List<Course> courses = new ArrayList<Course>();
		CallStoredProcedure proc = null;
		try
		{
			proc = new CallStoredProcedure("spLoadAllCourses()");
			ResultSet results = proc.executeWithResults();
			if (null != results)
			{
				while (results.next())
				{
					long id = results.getLong(1);
					String title = results.getString(2);
					Course c = new Course();
					c.setId(id);
					c.setTitle(title);
					courses.add(c);
				}
			}
			results.last();
			LOG.info("Operation = FetchAllCourses, Status = Success, RowCount="+results.getRow());
		}
		catch (SQLException e)
		{
			LOG.error("Status = Failed, Error Message="+e.getMessage());
		}
		finally
		{
			if (null != proc)
			{
				proc.cleanup();
			}
		}
		return courses;
	}

	public void loadCourseByID(long id, ICourse course)
	{
		CallStoredProcedure proc = null;
		try
		{
			proc = new CallStoredProcedure("spFindCourseByID(?)");
			proc.setParameter(1, id);
			ResultSet results = proc.executeWithResults();
			if (null != results)
			{
				while (results.next())
				{
					String title = results.getString(2);
					course.setId(id);
					course.setTitle(title);
				}
				LOG.info("Operation = FetchAllCourses, Status = Success, RowCount="+results.getRowId("1"));
			}
		}
		catch (SQLException e)
		{
			LOG.error("Status = Failed, Error Message="+e.getMessage());
		}
		finally
		{
			if (null != proc)
			{
				proc.cleanup();
			}
		}
	}

	public boolean createCourse(ICourse course)
	{
		CallStoredProcedure proc = null;
		try
		{
			proc = new CallStoredProcedure("spCreateCourse(?, ?)");
			proc.setParameter(1, course.getTitle());
			proc.registerOutputParameterLong(2);
			proc.execute();
			LOG.info("Operation = Course Created, Status = Success, CourseID="+course.getId());
		}
		catch (SQLException e)
		{
			LOG.error("Status = Failed, Error Message="+e.getMessage());
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
	
	public boolean deleteCourse(long id)
	{
		CallStoredProcedure proc = null;
		try
		{
			proc = new CallStoredProcedure("spDeleteCourse(?)");
			proc.setParameter(1, id);
			proc.execute();
			LOG.info("Operation = DeleteCourse, Status = Success, RowCount="+id);
		}
		catch (SQLException e)
		{
			LOG.error("Status = Failed, Error Message="+e.getMessage());
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
}

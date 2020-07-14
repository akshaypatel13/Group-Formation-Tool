package CSCI5308.GroupFormationTool.Courses;

import java.util.ArrayList;
import java.util.List;

import CSCI5308.GroupFormationTool.SystemConfig;
import CSCI5308.GroupFormationTool.AccessControl.*;
import CSCI5308.GroupFormationTool.Security.IPasswordEncryption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StudentCSVImport implements IStudentCSVImport
{
	private static final Logger LOG = LogManager.getLogger();
	private List<String> successResults;
	private List<String> failureResults;
	private ICourse course;
	private IUserPersistence userDB;
	private IPasswordEncryption passwordEncryption;
	private IStudentCSVParser parser;
	
	public StudentCSVImport(IStudentCSVParser parser, ICourse course)
	{
		this.course = course;
		successResults = new ArrayList<String>();
		failureResults = new ArrayList<String>();
		userDB = UserAbstractFactory.instance().createUserDBInstance();
		passwordEncryption = SystemConfig.instance().getPasswordEncryption();
		this.parser = parser;
		enrollStudentFromRecord();
	}
	
	public void enrollStudentFromRecord()
	{
		List<IUser> studentList = parser.parseCSVFile(failureResults);
		for(IUser u : studentList)
		{	
			String bannerID = u.getBanner();
			String firstName = u.getFirstName();
			String lastName = u.getLastName();
			String email = u.getEmail();
			String userDetails = bannerID + " " + firstName + " " + lastName +" " + email;
			
			IUser user = UserAbstractFactory.instance().createUserInstance();
			userDB.loadUserByBannerID(bannerID, user);
			///////////////////////////////////////////////////////////////////
			if (!user.isValidUser()) //////////////////////////////////////////
			{
				user.setBannerID(bannerID);
				user.setFirstName(firstName);
				user.setLastName(lastName);
				user.setEmail(email);
				if (user.createUser(userDB, passwordEncryption, null))
				{
					successResults.add("Created: " + userDetails);
					userDB.loadUserByBannerID(bannerID, user);
				}
				else
				{
					failureResults.add("Unable to save this user to DB: " + userDetails);
					return;
				}
			}
			if (course.enrollUserInCourse(Role.STUDENT, user))
			{
				successResults.add("User enrolled in course: " + userDetails);
			}else 
			{
				failureResults.add("Unable to enroll user in course: " + userDetails);
			}
		}
		if(failureResults.size() >= 1)
		{
			LOG.error("Failure to Enroll Users Count: "+failureResults.size()+" , Course: "+course.getId());
		}
		else{
			LOG.info("Users Enrolled Count: "+successResults.size()+" , Course: "+course.getId());
		}
	}
	
	public List<String> getSuccessResults()
	{
		return successResults;
	}
	
	public List<String> getFailureResults()
	{
		return failureResults;
	}
	
}

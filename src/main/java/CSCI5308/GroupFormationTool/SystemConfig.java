package CSCI5308.GroupFormationTool;

import CSCI5308.GroupFormationTool.Security.*;
import CSCI5308.GroupFormationTool.AccessControl.*;
import CSCI5308.GroupFormationTool.Database.*;
import CSCI5308.GroupFormationTool.QuestionManager.IQuestionPersistence;
import CSCI5308.GroupFormationTool.QuestionManager.QuestionDB;
import CSCI5308.GroupFormationTool.Response.IResponsePersistence;
import CSCI5308.GroupFormationTool.Response.ResponseDB;
import CSCI5308.GroupFormationTool.PasswordValidation.IPasswordValidatorEnumerator;
import CSCI5308.GroupFormationTool.PasswordValidation.IPasswordValidatorPersistence;
import CSCI5308.GroupFormationTool.PasswordValidation.PasswordValidatorDB;
import CSCI5308.GroupFormationTool.Courses.*;
import CSCI5308.GroupFormationTool.Survey.ISurveyAdminPersistence;
import CSCI5308.GroupFormationTool.Survey.ISurveyManagePersistence;
import CSCI5308.GroupFormationTool.Survey.SurveyAdminDB;
import CSCI5308.GroupFormationTool.Survey.SurveyManageDB;

/*
 * This is a singleton, we will learn about these when we learn design patterns.
 * 
 * The single responsibility of this singleton is to store concrete classes
 * selected by the system for use in the rest of the system. This will allow
 * a form of dependency injection in places where we cannot use normal
 * dependency injection (for example classes that override or extend existing
 * library classes in the framework).
 */
public class SystemConfig
{
	private static SystemConfig uniqueInstance = null;
	
	private IUserAbstractFactory userAbstractFactory;
	private IPasswordEncryption passwordEncryption;
	private IUserPersistence userDB;
	private IDatabaseConfiguration databaseConfiguration;
	private ICoursePersistence courseDB;
	private ICourseUserRelationshipPersistence courseUserRelationshipDB;
	private IQuestionPersistence questionDB;
	private IPasswordValidatorPersistence validatorDB;
	private IPasswordValidatorEnumerator passwordValidatorEnumerator;
	private ISurveyAdminPersistence surveyAdminDB;
	private ISurveyManagePersistence surveyManageDB;
	private IResponsePersistence responseDB;

	private SystemConfig()
	{
		userAbstractFactory= new UserAbstractFactory();
		passwordEncryption = new BCryptPasswordEncryption();
		userDB =new UserDB();
		databaseConfiguration = new DefaultDatabaseConfiguration();
		courseDB = new CourseDB();
		courseUserRelationshipDB = new CourseUserRelationshipDB();
		questionDB = new QuestionDB();
		validatorDB = new PasswordValidatorDB();
		surveyAdminDB = new SurveyAdminDB();
		surveyManageDB = new SurveyManageDB();
		responseDB = new ResponseDB();

	}
	
	public static SystemConfig instance()
	{
		if (null == uniqueInstance)
		{
			uniqueInstance = new SystemConfig();
		}
		return uniqueInstance;
	}
	
	public IPasswordEncryption getPasswordEncryption()
	{
		return passwordEncryption;
	}
	
	public void setPasswordEncryption(IPasswordEncryption passwordEncryption)
	{
		this.passwordEncryption = passwordEncryption;
	}
	
	public IUserPersistence getUserDB()
	{
		return userDB;
	}
	
	public void setUserDB(IUserPersistence userDB)
	{
		this.userDB = userDB;
	}
	
	public IDatabaseConfiguration getDatabaseConfiguration()
	{
		return databaseConfiguration;
	}
	
	public void setDatabaseConfiguration(IDatabaseConfiguration databaseConfiguration)
	{
		this.databaseConfiguration = databaseConfiguration;
	}
	
	public void setCourseDB(ICoursePersistence courseDB)
	{
		this.courseDB = courseDB;
	}
	
	public ICoursePersistence getCourseDB()
	{
		return courseDB;
	}
	
	public void setCourseUserRelationshipDB(ICourseUserRelationshipPersistence courseUserRelationshipDB)
	{
		this.courseUserRelationshipDB = courseUserRelationshipDB;
	}
	
	public ICourseUserRelationshipPersistence getCourseUserRelationshipDB()
	{
		return courseUserRelationshipDB;
	}
	
	public void setQuestionDB(IQuestionPersistence questionDB)
	{
		this.questionDB = questionDB;
	}
	
	public IQuestionPersistence getQuestionDB()
	{
		return questionDB;
	}
	public void setPasswordValidatorDB(IPasswordValidatorPersistence validatorDB)
	{
		this.validatorDB = validatorDB;
	}
	
	public IPasswordValidatorPersistence getPasswordValidatorDB()
	{
		return validatorDB;
	}
	
	public void setPasswordValidatorEnumerator(IPasswordValidatorEnumerator passwordValidatorEnumerator)
	{
		this.passwordValidatorEnumerator = passwordValidatorEnumerator;
	}
	
	public IPasswordValidatorEnumerator getPasswordValidatorEnumerator()
	{
		return passwordValidatorEnumerator;
	}


	public ISurveyAdminPersistence getSurveyAdminDB() {
		return surveyAdminDB;
	}

	public ISurveyManagePersistence getSurveyManageDB() {
		return surveyManageDB;
	}

	public IResponsePersistence getResponseDB() {
		return responseDB;
	}

	public void setResponseDB(IResponsePersistence responseDB) {
		this.responseDB = responseDB;
	}

	public IUserAbstractFactory getUserAbstractFactory() {
		return userAbstractFactory;
	}

	public void setUserAbstractFactory(IUserAbstractFactory userAbstarctFactory) {
		this.userAbstractFactory = userAbstarctFactory;
	}

}

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
import CSCI5308.GroupFormationTool.Survey.*;

public class SystemConfig {
	private static SystemConfig uniqueInstance = null;

	private IUserAbstractFactory userAbstractFactory;
	private ISecurityAbstractFactory securityAbstractFactory;
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
	private IGroupCreator groupCreator;

	

	private SystemConfig() {
//		passwordEncryption = securityAbstractFactory.createBCryptPasswordEncryption();
		//userDB = userAbstractFactory.createUserDBInstance();
		databaseConfiguration = new DefaultDatabaseConfiguration();
		courseDB = new CourseDB();
		courseUserRelationshipDB = new CourseUserRelationshipDB();
		questionDB = new QuestionDB();
		validatorDB = new PasswordValidatorDB();
		surveyAdminDB = new SurveyAdminDB();
		surveyManageDB = new SurveyManageDB();
		responseDB = new ResponseDB();
		groupCreator = new DefaultGroupCreator();

	}

	public static SystemConfig instance() {
		if (null == uniqueInstance) {
			uniqueInstance = new SystemConfig();
		}
		return uniqueInstance;
	}

	public IPasswordEncryption getPasswordEncryption() {
		return passwordEncryption;
	}

	public void setPasswordEncryption(IPasswordEncryption passwordEncryption) {
		this.passwordEncryption = passwordEncryption;
	}

	public IUserPersistence getUserDB() {
		return userDB;
	}

	public void setUserDB(IUserPersistence userDB) {
		this.userDB = userDB;
	}

	public IDatabaseConfiguration getDatabaseConfiguration() {
		return databaseConfiguration;
	}

	public void setDatabaseConfiguration(IDatabaseConfiguration databaseConfiguration) {
		this.databaseConfiguration = databaseConfiguration;
	}

	public void setCourseDB(ICoursePersistence courseDB) {
		this.courseDB = courseDB;
	}

	public ICoursePersistence getCourseDB() {
		return courseDB;
	}

	public void setCourseUserRelationshipDB(ICourseUserRelationshipPersistence courseUserRelationshipDB) {
		this.courseUserRelationshipDB = courseUserRelationshipDB;
	}


	public IGroupCreator getGroupCreator(){
		return groupCreator;
	}
	
	public ICourseUserRelationshipPersistence getCourseUserRelationshipDB()
	{
		return courseUserRelationshipDB;
	}

	public void setQuestionDB(IQuestionPersistence questionDB) {
		this.questionDB = questionDB;
	}

	public IQuestionPersistence getQuestionDB() {
		return questionDB;
	}

	public void setPasswordValidatorDB(IPasswordValidatorPersistence validatorDB) {
		this.validatorDB = validatorDB;
	}

	public IPasswordValidatorPersistence getPasswordValidatorDB() {
		return validatorDB;
	}

	public void setPasswordValidatorEnumerator(IPasswordValidatorEnumerator passwordValidatorEnumerator) {
		this.passwordValidatorEnumerator = passwordValidatorEnumerator;
	}

	public IPasswordValidatorEnumerator getPasswordValidatorEnumerator() {
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

	public ISecurityAbstractFactory getSecurityAbstractFactory() {
		return securityAbstractFactory;
	}

	public void setSecurityAbstractFactory(ISecurityAbstractFactory securityAbstractFactory) {
		this.securityAbstractFactory = securityAbstractFactory;
	}

}

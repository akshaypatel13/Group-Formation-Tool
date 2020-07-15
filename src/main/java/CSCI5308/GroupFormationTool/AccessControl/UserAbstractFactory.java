package CSCI5308.GroupFormationTool.AccessControl;


public class UserAbstractFactory {

	private static UserAbstractFactory uniqueInstance = null;
	private static IUserPersistence userDB;

	public static UserAbstractFactory instance() {
		if (null == uniqueInstance) {
			uniqueInstance = new UserAbstractFactory();
		}
		return uniqueInstance;
	}

	private UserAbstractFactory(){
		userDB = new UserDB();
	}

	public IUser createUserInstance() {
		return new User();
	}

	public IUserPersistence createUserDBInstance() {
		return userDB;
	}

	public IUser createUserParamInstance(String bannerID, IUserPersistence persistence) 
	{ return new User(bannerID,persistence);}
}

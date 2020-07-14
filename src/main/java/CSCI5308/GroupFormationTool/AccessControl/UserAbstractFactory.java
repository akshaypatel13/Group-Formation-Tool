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

	public UserAbstractFactory(){
		userDB = new UserDB();
		System.out.print("INIT USERDB: "+userDB.toString());
	}


	public IUser createUserInstance() {
		return new User();
	}

	public IUserPersistence createUserDBInstance() {
		System.out.print("USERDB: "+userDB.toString());
		return userDB;
	}
}

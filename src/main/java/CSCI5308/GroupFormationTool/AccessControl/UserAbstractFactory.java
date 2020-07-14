package CSCI5308.GroupFormationTool.AccessControl;

import CSCI5308.GroupFormationTool.SystemConfig;

import java.util.ArrayList;

public class UserAbstractFactory implements IUserAbstractFactory {

	private static UserAbstractFactory uniqueInstance = null;
	private IUserPersistence userDB;

	public static UserAbstractFactory instance() {
		if (null == uniqueInstance) {
			uniqueInstance = new UserAbstractFactory();
		}
		return uniqueInstance;
	}

	public UserAbstractFactory(){
		userDB = new UserDB();
	}

	@Override
	public IUser createUserInstance() {
		return new User();
	}

	@Override
	public IUserPersistence createUserDBInstance() {
		return userDB;
	}
}

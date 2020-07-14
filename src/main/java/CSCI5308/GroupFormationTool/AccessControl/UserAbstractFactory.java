package CSCI5308.GroupFormationTool.AccessControl;

import java.util.ArrayList;

public class UserAbstractFactory implements IUserAbstractFactory {

	@Override
	public IUser createUserInstance() {
		return new User();
	}

	@Override
	public ArrayList<IUser> createUserArrayList() {
		return new ArrayList<IUser>();
	}

	@Override
	public IUserPersistence createUserDBInstance() {
		return new UserDB();
	}
}

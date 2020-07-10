package CSCI5308.GroupFormationTool.AccessControl;

import java.util.ArrayList;

public class UserAbstractFactory implements IUserAbstractFactory {

	@Override
	public User createUserInstance()
	{
		return new User();
	}

	@Override
	public ArrayList<User> createUserArrayList() {
		return new ArrayList<User>();
	}

	@Override
	public IUserPersistence createUserDBInstance() {
		return new UserDB();
	}
}

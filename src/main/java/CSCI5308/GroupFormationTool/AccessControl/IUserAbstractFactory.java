package CSCI5308.GroupFormationTool.AccessControl;

import java.util.ArrayList;

public interface IUserAbstractFactory {
	public IUser createUserInstance();

	public ArrayList<IUser> createUserArrayList();

	public IUserPersistence createUserDBInstance();

}

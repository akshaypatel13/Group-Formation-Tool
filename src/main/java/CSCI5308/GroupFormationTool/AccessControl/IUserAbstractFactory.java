package CSCI5308.GroupFormationTool.AccessControl;

import java.util.ArrayList;

public interface IUserAbstractFactory {
	public User createUserInstance();
	public ArrayList<User>  createUserArrayList();
	
	public IUserPersistence createUserDBInstance();

}

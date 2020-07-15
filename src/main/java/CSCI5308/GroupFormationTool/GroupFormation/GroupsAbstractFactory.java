package CSCI5308.GroupFormationTool.GroupFormation;

import java.util.ArrayList;

import CSCI5308.GroupFormationTool.AccessControl.IUser;
import CSCI5308.GroupFormationTool.AccessControl.IUserPersistence;
import CSCI5308.GroupFormationTool.AccessControl.User;
import CSCI5308.GroupFormationTool.AccessControl.UserAbstractFactory;
import CSCI5308.GroupFormationTool.AccessControl.UserDB;

public class GroupsAbstractFactory implements IGroupsAbstractFactory {

	private static GroupsAbstractFactory uniqueInstance = null;

	private static IGroupsPersistence groupsDB;

	private static DefaultGroupCreator groupCreator;

	public static GroupsAbstractFactory instance() {
		if (null == uniqueInstance) {
			uniqueInstance = new GroupsAbstractFactory();
		}
		return uniqueInstance;
	}

	private GroupsAbstractFactory() {
		groupsDB = new GroupsDB();
		groupCreator = new DefaultGroupCreator();
	}

	public IGroups createGroupsInstance() {
		return new Groups();
	}

	public IGroupsPersistence createGroupsDBInstance() {
		return groupsDB;
	}

	public DefaultGroupCreator createDefaultGroupCreator() {
		return groupCreator;
	}

	public ArrayList<IGroups> createArrayListGroups() {
		return new ArrayList<IGroups>();
	}

	public IUser createUserParamInstance(String bannerID, IUserPersistence persistence) {
		return new User(bannerID, persistence);
	}

}

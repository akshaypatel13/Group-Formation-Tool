package CSCI5308.GroupFormationTool.GroupFormation;

import java.util.ArrayList;

public interface IGroupsAbstractFactory {

	public IGroups createGroupsInstance();

	public IGroupsPersistence createGroupsDBInstance();

	public DefaultGroupCreator createDefaultGroupCreator();

	public ArrayList<IGroups> createArrayListGroups();

}

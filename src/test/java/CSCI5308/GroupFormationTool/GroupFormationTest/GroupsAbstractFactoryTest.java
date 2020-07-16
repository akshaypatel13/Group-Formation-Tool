package CSCI5308.GroupFormationTool.GroupFormationTest;

import java.util.ArrayList;

import CSCI5308.GroupFormationTool.GroupFormation.DefaultGroupCreator;
import CSCI5308.GroupFormationTool.GroupFormation.Groups;
import CSCI5308.GroupFormationTool.GroupFormation.IGroups;
import CSCI5308.GroupFormationTool.GroupFormation.IGroupsPersistence;

public class GroupsAbstractFactoryTest {
	private static GroupsAbstractFactoryTest uniqueInstance = null;

	private static IGroupsPersistence groupsDBMock;

	private static DefaultGroupCreator groupCreator;

	public static GroupsAbstractFactoryTest instance() {
		if (null == uniqueInstance) {
			uniqueInstance = new GroupsAbstractFactoryTest();
		}
		return uniqueInstance;
	}

	private GroupsAbstractFactoryTest() {
		groupsDBMock = new GroupsDBMock();
		groupCreator = new DefaultGroupCreator();

	}

	public IGroups createGroupsInstanceTest() {
		return new Groups();
	}

	public IGroupsPersistence createGroupsDBInstanceTest() {
		return groupsDBMock;
	}

	public DefaultGroupCreator createDefaultGroupCreatorTest() {
		return groupCreator;
	}

	public ArrayList<IGroups> createArrayListGroupsTest() {
		return new ArrayList<IGroups>();
	}

}

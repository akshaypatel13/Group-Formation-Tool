package CSCI5308.GroupFormationTool.GroupFormationTest;

import java.util.ArrayList;

import CSCI5308.GroupFormationTool.GroupFormation.IGroups;
import CSCI5308.GroupFormationTool.GroupFormation.IGroupsPersistence;

public class GroupsDBMock implements IGroupsPersistence {

	@Override
	public boolean insertGroups(ArrayList<IGroups> groups) {
		if (groups.size() == 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public ArrayList<IGroups> fetchGroups() {
		ArrayList<IGroups> groups = GroupsAbstractFactoryTest.instance().createArrayListGroupsTest();
		IGroups group = GroupsAbstractFactoryTest.instance().createGroupsInstanceTest();
		group.setBannerId("B009876");
		group.setFirstName("rob");
		group.setGroupId(3);
		group.setLastName("hawkey");
		group.setStudentId(1);
		group.setSurveyId(1);
		groups.add(group);
		return groups;
	}

}

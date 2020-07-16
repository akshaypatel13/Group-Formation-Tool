package CSCI5308.GroupFormationTool.GroupFormationTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import CSCI5308.GroupFormationTool.GroupFormation.IGroups;
import CSCI5308.GroupFormationTool.GroupFormation.IGroupsPersistence;

@SpringBootTest
public class GroupsTest {

	@Test
	public void getSurveyId() {
		IGroups group = GroupsAbstractFactoryTest.instance().createGroupsInstanceTest();
		group.setSurveyId(10);
		assertEquals(10, group.getSurveyId());
	}

	@Test
	public void setSurveyId() {
		IGroups group = GroupsAbstractFactoryTest.instance().createGroupsInstanceTest();
		group.setSurveyId(1);
		assertEquals(1, group.getSurveyId());
	}

	@Test
	public void getGroupId() {
		IGroups group = GroupsAbstractFactoryTest.instance().createGroupsInstanceTest();
		group.setGroupId(5);
		assertEquals(5, group.getGroupId());
	}

	@Test
	public void setGroupId() {
		IGroups group = GroupsAbstractFactoryTest.instance().createGroupsInstanceTest();
		group.setGroupId(10);
		assertEquals(10, group.getGroupId());
	}

	@Test
	public void getStudentId() {
		IGroups group = GroupsAbstractFactoryTest.instance().createGroupsInstanceTest();
		group.setStudentId(15);
		assertEquals(15, group.getStudentId());
	}

	@Test
	public void setStudentId() {
		IGroups group = GroupsAbstractFactoryTest.instance().createGroupsInstanceTest();
		group.setStudentId(15);
		assertEquals(15, group.getStudentId());
	}

	@Test
	public void getFirstName() {
		IGroups group = GroupsAbstractFactoryTest.instance().createGroupsInstanceTest();
		group.setFirstName("abc");
		assertEquals("abc", group.getFirstName());
	}

	@Test
	public void setFirstName() {
		IGroups group = GroupsAbstractFactoryTest.instance().createGroupsInstanceTest();
		group.setFirstName("xyz");
		assertEquals("xyz", group.getFirstName());
	}

	@Test
	public void insertGroups() {
		IGroupsPersistence groupsDBMock = GroupsAbstractFactoryTest.instance().createGroupsDBInstanceTest();

		IGroups groups = GroupsAbstractFactoryTest.instance().createGroupsInstanceTest();
		ArrayList<IGroups> groupList =GroupsAbstractFactoryTest.instance().createArrayListGroupsTest(); 

		assertFalse(groupsDBMock.insertGroups(groups));
		groupList = groupsDBMock.fetchGroups();
		groups.setBannerId("B0999");
		assertTrue(groupsDBMock.insertGroups(groups));

	}

	@Test
	public void getLastName() {
		IGroups group = GroupsAbstractFactoryTest.instance().createGroupsInstanceTest();
		group.setLastName("abc");
		assertEquals("abc", group.getLastName());
	}

	@Test
	public void setLastName() {
		IGroups group = GroupsAbstractFactoryTest.instance().createGroupsInstanceTest();
		group.setLastName("abc");
		assertEquals("abc", group.getLastName());
	}

	@Test
	public void getBannerId() {
		IGroups group = GroupsAbstractFactoryTest.instance().createGroupsInstanceTest();
		group.setBannerId("B0098");
		assertEquals("B0098", group.getBannerId());
	}

	@Test
	public void setBannerId() {
		IGroups group = GroupsAbstractFactoryTest.instance().createGroupsInstanceTest();
		group.setBannerId("B00981");
		assertEquals("B00981", group.getBannerId());
	}

	public void fetchGroups() {
		IGroupsPersistence groupsDBMock = GroupsAbstractFactoryTest.instance().createGroupsDBInstanceTest();

		ArrayList<IGroups> groups = groupsDBMock.fetchGroups();
		for (IGroups group : groups) {
			assertEquals(group.getBannerId(), "B009876");
			assertNotEquals(group.getBannerId(), "B0076");
			assertEquals(group.getFirstName(), "rob");
			assertNotEquals(group.getFirstName(), "acv");
		}
	}

}

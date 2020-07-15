package CSCI5308.GroupFormationTool.GroupFormation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;

public class GroupsDB implements IGroupsPersistence {

	public boolean insertGroups(ArrayList<IGroups> groups) {
		for (IGroups group : groups) {

			CallStoredProcedure proc = null;
			try {
				proc = new CallStoredProcedure("spCreateGroup(?, ?, ?)");
				proc.setParameter(1, group.getGroupId());
				proc.setParameter(2, group.getSurveyId());
				proc.setParameter(3, group.getStudentId());
				proc.execute();
			} catch (SQLException e) {
				// Logging needed
				return false;
			} finally {
				if (null != proc) {
					proc.cleanup();
				}
			}

		}
		return true;
	}

	@Override
	public ArrayList<IGroups> fetchGroups() {
		CallStoredProcedure proc = null;
		ArrayList<IGroups> groupsInfo =GroupsAbstractFactory
				.instance().createArrayListGroups();
		try {
			proc = new CallStoredProcedure("spFetchGroupsInfo()");
			ResultSet results = proc.executeWithResults();
			if (null != results) {
				while (results.next()) {
					IGroups group =GroupsAbstractFactory.
							instance().createGroupsInstance();
					int groupid = results.getInt(1);
					String bannerID = results.getString(4);

					String firstName = results.getString(5);
					String lastName = results.getString(6);
					group.setGroupId(groupid);
					group.setBannerId(bannerID);
					group.setFirstName(firstName);
					group.setLastName(lastName);
					groupsInfo.add(group);

				}
			}
		} catch (SQLException e) {
			// Logging needed.
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		return groupsInfo;
	}
}

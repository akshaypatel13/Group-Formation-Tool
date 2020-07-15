package CSCI5308.GroupFormationTool.GroupFormation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;

public class GroupsDB implements IGroupsPersistence {
	private static final Logger LOG = LogManager.getLogger();

	public boolean insertGroups(ArrayList<IGroups> groups) {
		for (IGroups group : groups) {

			CallStoredProcedure proc = null;
			try {
				proc = new CallStoredProcedure("spCreateGroup(?, ?, ?)");
				proc.setParameter(1, group.getGroupId());
				proc.setParameter(2, group.getSurveyId());
				proc.setParameter(3, group.getStudentId());
				proc.execute();
				LOG.info("Operation = Groups info Inserted, Status = Success, GroupId=" + group.getGroupId());
			} catch (SQLException e) {
				LOG.error("Status = Failed, Error Message=" + e.getMessage());
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
		ArrayList<IGroups> groupsInfo = GroupsAbstractFactory.instance().createArrayListGroups();
		try {
			proc = new CallStoredProcedure("spFetchGroupsInfo()");
			ResultSet results = proc.executeWithResults();
			if (null != results) {
				while (results.next()) {
					IGroups group = GroupsAbstractFactory.instance().createGroupsInstance();
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
				LOG.info("Operation = Groups info fetched, Status = Success, RowCount:" + results.getRow());
			}
		} catch (SQLException e) {
			LOG.error("Status = Failed, Error Message=" + e.getMessage());
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		return groupsInfo;
	}
}

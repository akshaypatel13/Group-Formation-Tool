package CSCI5308.GroupFormationTool.GroupFormation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import CSCI5308.GroupFormationTool.Survey.ISurveyManagePersistence;

public class Groups implements IGroups {

	private long surveyId;
	private int groupId;
	private long studentId;
	private String firstName;
	private String lastName;
	private String bannerId;
	private static final Logger LOG = LogManager.getLogger();

	public long getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(long surveyId) {
		this.surveyId = surveyId;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public long getStudentId() {
		return studentId;
	}

	@Override
	public void setStudentId(long a) {
		this.studentId = a;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public boolean insertGroups(IGroupsPersistence groupDB, long surveyId, IGroupCreator groupCreator,
			ISurveyManagePersistence surveyManageDB) {
		LOG.info("Fetching responses for survey , SurveyId:" + surveyId);
		Boolean status = true;
		Map<Long, Map<Long, String>> responses = surveyManageDB.getSurveyResponses(surveyId);
		Map<Long, Long> surveyAlgo = surveyManageDB.getSurveyGroupAlgo(surveyId);
		long groupSize = surveyManageDB.getSurveyGroupSize(surveyId);
		Map<Integer, List<Long>> groups = new HashMap<Integer, List<Long>>();
		LOG.info("Fetching groups from groups created for SurveyId:" + surveyId);
		groups = groupCreator.createGroups(responses, surveyAlgo, groupSize);
		ArrayList<IGroups> groupsList = GroupsAbstractFactory.instance().createArrayListGroups();

		for (Entry<Integer, List<Long>> entry : groups.entrySet()) {
			Integer key = entry.getKey();
			List<Long> value = entry.getValue();
			for (Long a : value) {
				IGroups group = GroupsAbstractFactory.instance().createGroupsInstance();
				group.setGroupId(key);
				group.setSurveyId(surveyId);
				group.setStudentId(a);
				groupsList.add(group);
			}

		}
		LOG.info("Calling groupsDB to insert groups in Database");
		for(IGroups group:groupsList) {
			status = groupDB.insertGroups(group);
		}
		
		return status;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean createGroups() {

		return false;
	}

	public String getBannerId() {
		return bannerId;
	}

	public void setBannerId(String bannerId) {
		this.bannerId = bannerId;
	}

	public Map<Integer, ArrayList<IGroups>> fetchGroups(IGroupsPersistence groupDB) {
		LOG.info("Fetching groups from Database for SurveyId:" + surveyId);
		ArrayList<IGroups> groups = groupDB.fetchGroups();
		Map<Integer, ArrayList<IGroups>> mapGroups = new HashMap<Integer, ArrayList<IGroups>>();
		ArrayList<Integer> uniqueGroups = new ArrayList<Integer>();

		for (IGroups group : groups) {
			int groupId = group.getGroupId();
			if (uniqueGroups.contains(groupId)) {
				ArrayList<IGroups> existingGroupValues = GroupsAbstractFactory.instance().createArrayListGroups();
				existingGroupValues = mapGroups.get(groupId);
				existingGroupValues.add(group);
				mapGroups.replace(groupId, existingGroupValues);
			} else {
				uniqueGroups.add(groupId);
				ArrayList<IGroups> uniqueGroupValues = GroupsAbstractFactory.instance().createArrayListGroups();
				uniqueGroupValues.add(group);
				mapGroups.put(groupId, uniqueGroupValues);

			}
		}

		return mapGroups;
	}

}

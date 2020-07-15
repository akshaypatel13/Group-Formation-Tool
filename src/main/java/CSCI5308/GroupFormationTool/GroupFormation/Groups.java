package CSCI5308.GroupFormationTool.GroupFormation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import CSCI5308.GroupFormationTool.Survey.ISurveyManagePersistence;

public class Groups implements IGroups {

	private long surveyId;
	private int groupId;
	private long studentId;
	private String firstName;
	private String lastName;
	private String bannerId;

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
		Map<Long, Map<Long, String>> responses = surveyManageDB.getSurveyResponses(surveyId);
		long groupSize = surveyManageDB.getSurveyGroupSize(surveyId);
		Map<Integer, List<Long>> groups = new HashMap<Integer, List<Long>>();

		groups = groupCreator.createGroups(responses, groupSize);
		System.out.println(groups.size());
		ArrayList<IGroups> groups1 = new ArrayList<IGroups>();

		for (Entry<Integer, List<Long>> entry : groups.entrySet()) {
			Integer key = entry.getKey();
			List<Long> value = entry.getValue();
			for (Long a : value) {
				Groups g = new Groups();
				g.setGroupId(key);
				g.setSurveyId(surveyId);
				g.setStudentId(a);
				groups1.add(g);
			}

		}
		groupDB.insertGroups(groups1);
		return false;
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

	public  Map<Integer, ArrayList<IGroups>> fetchGroups(IGroupsPersistence groupDB) {
		
		ArrayList<IGroups> groups = groupDB.fetchGroups();
		Map<Integer, ArrayList<IGroups>> mapGroups = new HashMap<Integer, ArrayList<IGroups>>();
		ArrayList<Integer> uniqueGroups = new ArrayList<Integer>();
		
		for (IGroups group: groups) {
			int groupId = group.getGroupId();
			if (uniqueGroups.contains(groupId)) {
				ArrayList<IGroups> existingGroupValues = new ArrayList<IGroups>();
				existingGroupValues = mapGroups.get(groupId);
				existingGroupValues.add(group);
				mapGroups.replace(groupId, existingGroupValues); 
			} else {
				uniqueGroups.add(groupId);
				ArrayList<IGroups> uniqueGroupValues = new ArrayList<IGroups>();
				uniqueGroupValues.add(group);
				mapGroups.put(groupId, uniqueGroupValues);
				
			}
		}

		return mapGroups;
	}

}

package CSCI5308.GroupFormationTool.GroupFormation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Groups implements IGroups {

	private long surveyId;
	private int groupId;
	private int studentId;
	private String firstName;
	private String lastName;

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

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public boolean insertGroups(IGroupsPersistence groupDB, long surveyId) {
		Map<Integer, ArrayList<Integer>> groups = new HashMap<Integer, ArrayList<Integer>>();
		ArrayList<Integer> students1 = new ArrayList<Integer>();
		ArrayList<Integer> students2 = new ArrayList<Integer>();
		students1.add(1);
		students1.add(2);
		students1.add(3);
		students2.add(4);
		students2.add(5);
		students2.add(6);
		groups.put(1, students1);
		groups.put(2, students2);
		ArrayList<IGroups> groups1 = new ArrayList<IGroups>();

		for (Map.Entry<Integer, ArrayList<Integer>> entry : groups.entrySet()) {
			Integer key = entry.getKey();
			ArrayList<Integer> value = entry.getValue();
			for (Integer a : value) {
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

}

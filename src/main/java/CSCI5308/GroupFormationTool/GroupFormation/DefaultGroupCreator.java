package CSCI5308.GroupFormationTool.GroupFormation;

import java.util.*;

public class DefaultGroupCreator implements IGroupCreator {
	@Override
	public Map<Integer, List<Long>> createGroups(Map<Long, Map<Long, String>> responses, long size) {

		Map<Long, String> oneResponse = responses.get(responses.keySet().toArray()[0]);
		Set<Long> studentsSet = oneResponse.keySet();

		int noOfStudents = studentsSet.size();
		Map<Integer, List<Long>> groups = new HashMap<>();

		List<Long> students = new LinkedList<>(studentsSet);

		int groupNumber = 0;

		int noOfGroups = (int) Math.ceil(noOfStudents / size);

		while (groupNumber < noOfGroups - 1) {

			List<Long> studentsInGroup = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				int index = (int) (Math.random() * students.size());
				studentsInGroup.add(students.get(index));
				students.remove(index);
			}
			groups.put(groupNumber, studentsInGroup);
			groupNumber++;

		}
		List<Long> studentsInGroup = new ArrayList<>();
		studentsInGroup.addAll(students);

		groups.put(groupNumber, studentsInGroup);

		return groups;
	}
}

package CSCI5308.GroupFormationTool.GroupFormation;

import java.util.*;

public class DefaultGroupCreator implements IGroupCreator {

	private long groupSize;
	private Map<Long, Map<Long, String>> responses;
	private final int compatibilityThresholdUpperBound = 80;
	private final int compatibilityThresholdLowerBound = 50;
	private final int compatibilityThresholdDecrementRate = 5;

	public Map<Integer, List<Long>> createGroups(Map<Long, Map<Long, String>> responses, Map<Long, Long> algo,
			long size) {

		Map<Long, String> oneResponse = responses.get(responses.keySet().toArray()[0]);
		Set<Long> students = oneResponse.keySet();
		int noOfStudents = students.size();
		this.groupSize = size;
		Map<Integer, List<Long>> groups = new HashMap<>();
		this.responses = responses;

		List<Long> studentsList = new LinkedList<>(students);

		int noOfGroups;
		if (noOfStudents % size == 0) {
			noOfGroups = (int) (noOfStudents / size);
		} else {
			noOfGroups = (int) ((noOfStudents / size) + 1);
		}

		for (int i = 1; i <= noOfGroups; i++) {
			List<Long> initialGroup = new LinkedList<>();
			groups.put(i, initialGroup);
		}

		while (studentsList.size() > 0) {

			long student = studentsList.iterator().next();
			int assignedGroupNumber = assignGroupBasedOnAdaptiveCompatibility(student, groups, algo);
			List<Long> assignedGroup = groups.get(assignedGroupNumber);

			assignedGroup.add(student);
			studentsList.remove(student);

		}

		return groups;
	}

	private int assignGroupBasedOnAdaptiveCompatibility(long student, Map<Integer, List<Long>> groups,
			Map<Long, Long> algo) {

		int answer = 0;
		boolean notAssigned = true;
		int currentThreshold = compatibilityThresholdUpperBound;

		while (currentThreshold >= compatibilityThresholdLowerBound) {
			for (int groupNumber : groups.keySet()) {
				List<Long> group = groups.get(groupNumber);
				if (studentGroupCompatibility(student, group, algo, currentThreshold)) {
					answer = groupNumber;
					notAssigned = false;
					break;
				}
			}
			if (notAssigned) {
				currentThreshold -= compatibilityThresholdDecrementRate;
			} else {
				break;
			}
		}

		if (notAssigned) {
			for (int groupNumber : groups.keySet()) {
				List<Long> group = groups.get(groupNumber);
				if (group.size() == 0) {
					notAssigned = false;
					answer = groupNumber;
					break;
				}
			}
		}

		if (notAssigned) {
			for (int groupNumber : groups.keySet()) {
				List<Long> group = groups.get(groupNumber);
				if (group.size() < this.groupSize) {
					notAssigned = false;
					answer = groupNumber;
					break;
				}
			}
		}

		return answer;
	}

	private boolean studentGroupCompatibility(long student, List<Long> group, Map<Long, Long> algo, double matchRate) {
		int noOfQuestions = responses.size();
		for (int i = 0; i < group.size(); i++) {
			int match = 0;
			for (long question : responses.keySet()) {
				Map<Long, String> response = responses.get(question);
				long algoType = algo.get(question);
				boolean responseMatch = response.get(student).equals(response.get(i));
				if (responseMatch) {
					if (algoType == 1) {
						match++;
					}
				} else {
					if (algoType == 2) {
						match++;
					}
				}
			}
			double matching = (match / noOfQuestions) * 100;
			if (matching < matchRate) {
				return false;
			}
		}
		return true;
	}

}

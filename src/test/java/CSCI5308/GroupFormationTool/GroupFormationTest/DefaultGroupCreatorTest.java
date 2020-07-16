package CSCI5308.GroupFormationTool.GroupFormationTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import CSCI5308.GroupFormationTool.GroupFormation.DefaultGroupCreator;
import CSCI5308.GroupFormationTool.GroupFormation.IGroupCreator;

public class DefaultGroupCreatorTest {
	@Test
	public void createGroupsTest() {
		IGroupCreator groupCreator = new DefaultGroupCreator();

		int students = 11;
		int questions = 4;

		int groupSize = 3;
		int noOfGroups;
		if(students % groupSize == 0){
			noOfGroups = (int) (students / groupSize);
		}else{
			noOfGroups = (int) ((students / groupSize)+1);
		}
		Map<Long, Map<Long, String>> responses = new HashMap<>();

		for(long i=0;i<questions;i++){

			Map<Long, String> responsesForQuestion = new HashMap<>();
			for(long j=0;j<students;j++){
				responsesForQuestion.put(j, "answer");
			}
			responses.put(i, responsesForQuestion);
		}
		Map<Long, Long> algo = new HashMap<>();
		for(long i=0;i<questions;i++){

			algo.put(i,1l);

		}

		Map<Integer, List<Long>>  groups = groupCreator.createGroups(responses, algo, groupSize);
		List<Long> oneGroup = groups.get(groups.keySet().toArray()[0]);

		Assert.isTrue(groups.size() == noOfGroups);
		Assert.isTrue(oneGroup.size() == groupSize);
	}

}

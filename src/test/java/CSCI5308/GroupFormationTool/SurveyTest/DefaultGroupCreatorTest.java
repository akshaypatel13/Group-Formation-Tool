package CSCI5308.GroupFormationTool.SurveyTest;

import CSCI5308.GroupFormationTool.Survey.DefaultGroupCreator;
import CSCI5308.GroupFormationTool.Survey.IGroupCreator;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import javax.validation.constraints.AssertTrue;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DefaultGroupCreatorTest {

    @Test
    public void createGroupsTest(){
        IGroupCreator groupCreator = new DefaultGroupCreator();

        int students = 12;
        int questions = 4;

        int groupSize = 3;
        int noOfGroups = students / groupSize;
        Map<Long, Map<Long, String>> responses = new HashMap<>();

        for(long i=0;i<questions;i++){

            Map<Long, String> responsesForQuestion = new HashMap<>();
            for(long j=0;j<students;j++){
                responsesForQuestion.put(j, "answer");
            }
            responses.put(i, responsesForQuestion);
        }
        Map<Integer, List<Long>>  groups = groupCreator.createGroups(responses, groupSize);
        List<Long> oneGroup = groups.get(groups.keySet().toArray()[0]);

        Assert.isTrue(groups.size() == noOfGroups);
        Assert.isTrue(oneGroup.size() == groupSize);
    }
}

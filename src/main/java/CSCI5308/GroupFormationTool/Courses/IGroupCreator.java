package CSCI5308.GroupFormationTool.Courses;

import java.util.List;
import java.util.Map;

public interface IGroupCreator {

    public Map<Integer, List<Integer>> createGroups(int courseID, int size);
}

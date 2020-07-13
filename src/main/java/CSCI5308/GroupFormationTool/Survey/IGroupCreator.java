package CSCI5308.GroupFormationTool.Survey;

import java.util.List;
import java.util.Map;

public interface IGroupCreator {

    public Map<Integer, List<Long>> createGroups(Map<Long, Map<Long, String>> responses, long size);
}

package CSCI5308.GroupFormationTool.GroupFormation;

import java.util.List;
import java.util.Map;

public interface IGroupCreator {

	public Map<Integer, List<Long>> createGroups(Map<Long, Map<Long, String>> responses, Map<Long, Long> algo,  long size);
}

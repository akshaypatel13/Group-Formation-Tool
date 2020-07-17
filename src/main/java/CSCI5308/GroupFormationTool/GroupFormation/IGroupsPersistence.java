package CSCI5308.GroupFormationTool.GroupFormation;

import java.util.ArrayList;

public interface IGroupsPersistence {

	public boolean insertGroups(IGroups group);

	public ArrayList<IGroups> fetchGroups();
}

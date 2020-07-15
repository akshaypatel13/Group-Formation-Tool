package CSCI5308.GroupFormationTool.GroupFormation;

import java.util.ArrayList;

public interface IGroupsPersistence {

	public boolean insertGroups(ArrayList<IGroups> groups);

	public ArrayList<IGroups> fetchGroups();
}

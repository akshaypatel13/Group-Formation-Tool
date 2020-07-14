package CSCI5308.GroupFormationTool.GroupFormation;

import java.sql.SQLException;
import java.util.ArrayList;

import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;

public class GroupsDB implements IGroupsPersistence {
	
	public  boolean insertGroups(ArrayList<IGroups> groups)
	{
	    for(IGroups group : groups)
	    {

			CallStoredProcedure proc = null;
			try
			{
				proc = new CallStoredProcedure("spCreateGroup(?, ?, ?)");
				proc.setParameter(1, group.getGroupId());
				proc.setParameter(2,group.getSurveyId());
				proc.setParameter(3, group.getStudentId());
				proc.execute();
			}
			catch (SQLException e)
			{
				// Logging needed
				return false;
			}
			finally
			{
				if (null != proc)
				{
					proc.cleanup();
				}
			}

	    }
		return true;
	}
}

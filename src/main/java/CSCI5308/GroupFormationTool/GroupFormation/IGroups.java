package CSCI5308.GroupFormationTool.GroupFormation;

import java.util.ArrayList;
import java.util.Map;

import CSCI5308.GroupFormationTool.Survey.ISurveyManagePersistence;

public interface IGroups {

	public long getSurveyId();

	public void setSurveyId(long surveyId);

	public int getGroupId();

	public void setGroupId(int groupId);

	public long getStudentId();

	public void setStudentId(long studentId);

	public String getFirstName();

	public void setFirstName(String firstName);

	public String getLastName();

	public void setLastName(String lastName);

	public boolean createGroups();

	public boolean insertGroups(IGroupsPersistence groupDB, long surveyId, IGroupCreator groupCreator,
			ISurveyManagePersistence surveyManageDB);

	public String getBannerId();

	public void setBannerId(String bannerId);

	public Map<Integer, ArrayList<IGroups>> fetchGroups(IGroupsPersistence groupDB);

}

package CSCI5308.GroupFormationTool.GroupFormation;

public interface IGroups {

	public long getSurveyId();

	public void setSurveyId(long surveyId);

	public int getGroupId();

	public void setGroupId(int groupId);

	public int getStudentId();

	public void setStudentId(int studentId);

	public String getFirstName();

	public void setFirstName(String firstName);

	public String getLastName();

	public void setLastName(String lastName);

	public boolean createGroups();

	public boolean insertGroups(IGroupsPersistence groupDB,long surveyId);
}

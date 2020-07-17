package CSCI5308.GroupFormationTool.Survey;

public interface ISurveyAbstractFactory {

	public SurveyAdminDB createSurveyAdminDBInstance();

	public SurveyManageDB createSurveyManageDBInstance();

}

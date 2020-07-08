package CSCI5308.GroupFormationTool.Survey;

public interface ISurveyAdminPersistence
{
    public boolean createSurvey(long courseID);
    public boolean insertSurveyQuestion(long surveyID, long questionID);
    public boolean deleteSurveyQuestion(long questionID);
    public boolean publishSurvey(long courseID);
    public boolean disableSurvey(long courseID);
}

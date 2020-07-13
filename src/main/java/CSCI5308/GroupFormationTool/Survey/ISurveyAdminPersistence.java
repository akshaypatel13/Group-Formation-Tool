package CSCI5308.GroupFormationTool.Survey;

public interface ISurveyAdminPersistence
{
    public boolean createSurvey(long courseID);
    public boolean insertSurveyQuestion(long surveyID, long questionID, long algo);
    public boolean deleteSurveyQuestion(long questionID);
    public boolean publishSurvey(long courseID, long groupSize);
    public boolean disableSurvey(long courseID);
}

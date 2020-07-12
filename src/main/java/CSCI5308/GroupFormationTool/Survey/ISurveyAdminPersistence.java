package CSCI5308.GroupFormationTool.Survey;

import java.util.List;

import CSCI5308.GroupFormationTool.QuestionManager.Question;

public interface ISurveyAdminPersistence
{
    public boolean createSurvey(long courseID);
    public boolean insertSurveyQuestion(long surveyID, long questionID);
    public boolean deleteSurveyQuestion(long questionID);
    public boolean publishSurvey(long courseID);
    public boolean disableSurvey(long courseID);
	public List<Question> sortQuestionByDateCreated(List<Question> quesionsWithoutOptions, List<Question> quesionsWithOptions);
}

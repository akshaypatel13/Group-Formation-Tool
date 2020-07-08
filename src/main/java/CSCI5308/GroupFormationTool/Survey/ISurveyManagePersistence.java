package CSCI5308.GroupFormationTool.Survey;

import CSCI5308.GroupFormationTool.QuestionManager.Question;

import java.util.List;

public interface ISurveyManagePersistence
{
    public long findSurveyByCourseID(long courseID);
    public List<Question> findSurveyQuestions(long courseID);
    public List<Question> findQuestionsNotInSurvey(long userID);
    public boolean surveyPublishedOrNot(long courseID);
}

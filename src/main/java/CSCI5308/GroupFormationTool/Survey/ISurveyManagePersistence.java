package CSCI5308.GroupFormationTool.Survey;

import CSCI5308.GroupFormationTool.QuestionManager.IQuestion;
import CSCI5308.GroupFormationTool.QuestionManager.Question;

import java.util.List;

public interface ISurveyManagePersistence
{
    public long findSurveyByCourseID(long courseID);
    public List<IQuestion> findSurveyQuestions(long courseID);
    public List<IQuestion> findQuestionsNotInSurvey(long userID);
    public boolean surveyPublishedOrNot(long courseID);
}

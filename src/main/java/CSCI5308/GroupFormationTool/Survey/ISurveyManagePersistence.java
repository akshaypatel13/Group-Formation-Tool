package CSCI5308.GroupFormationTool.Survey;

import CSCI5308.GroupFormationTool.QuestionManager.IQuestion;

import java.util.List;
import java.util.Map;

public interface ISurveyManagePersistence {
	public long findSurveyByCourseID(long courseID);

	public List<IQuestion> findSurveyQuestions(long courseID);

	public List<IQuestion> findQuestionsNotInSurvey(long userID);

	public boolean surveyPublishedOrNot(long courseID);

	public Map<Long, Map<Long, String>> getSurveyResponses(long surveyID);

	public Map<Long, Long> getSurveyGroupAlgo(long surveyID);

	public long getSurveyGroupSize(long surveyID);
}

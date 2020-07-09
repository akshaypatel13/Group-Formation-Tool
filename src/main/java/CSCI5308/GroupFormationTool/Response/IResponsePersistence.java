package CSCI5308.GroupFormationTool.Response;

import CSCI5308.GroupFormationTool.QuestionManager.Question;

import java.util.HashMap;
import java.util.List;

public interface IResponsePersistence {
	public List<Question> loadQuestionsWithoutOptions(long courseId);
	public List<Question> loadQuestionsWithOptions(long courseId);
	public List<Question> loadQuestionsOptions(List<Question> quesions);
	public void saveResponse(HashMap<String, String> answer, String bannerId);
	public boolean checkIsMCQMultiple(String questionId);
}

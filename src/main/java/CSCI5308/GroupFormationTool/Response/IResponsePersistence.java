package CSCI5308.GroupFormationTool.Response;

import CSCI5308.GroupFormationTool.QuestionManager.IQuestion;

import java.sql.SQLException;
import java.util.List;

public interface IResponsePersistence {

	public List<IQuestion> loadQuestionsWithoutOptions(long courseId);

	public List<IQuestion> loadQuestionsWithOptions(long courseId);

	public IQuestion loadQuestionsOptions(IQuestion question);

	public boolean saveResponse(String questionId, String bannerId, String option) throws SQLException;

	public boolean checkIsMCQMultiple(String questionId);

}

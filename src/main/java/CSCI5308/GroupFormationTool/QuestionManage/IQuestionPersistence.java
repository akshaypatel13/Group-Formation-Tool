package CSCI5308.GroupFormationTool.QuestionManage;

import java.util.List;

import CSCI5308.GroupFormationTool.AccessControl.User;

/**
 * 
 * @author nieruize
 *
 */
public interface IQuestionPersistence
{
	public List<Question> loadAllQuestions(User user);
	public void loadQuestionByID(long id, Question question);
	public List<Question> sortQuestionsByTitle(User user);
	public List<Question> sortQuestionsByCreated(User user);
	public boolean deleteQuestion(long id);
	public boolean insertQuestion(Question question, User user);
	public boolean insertOptions(Options options);
}

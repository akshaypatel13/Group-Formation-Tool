package CSCI5308.GroupFormationTool.QuestionManage;

import java.util.List;

import CSCI5308.GroupFormationTool.AccessControl.User;

/**
 * 
 * @author nieruize
 *
 */
public interface IQuestionPersistence {
	public List<Question> loadAllQuestions(User user);
	public void loadQuestionByID(long id, Question question);
	public List<Question> sortAllQuestions(String sort, User user);
	public boolean deleteQuestion(long id);
}

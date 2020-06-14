package CSCI5308.GroupFormationTool.QuestionManage;

import java.util.List;

/**
 * 
 * @author nieruize
 *
 */
public interface IQuestionPersistence {
	public List<Question> loadAllQuestions();
	public void loadQuestionByID(long id, Question question);
	public List<Question> sortAllQuestions(String sort);
	public boolean deleteQuestion(long id);
}

package CSCI5308.GroupFormationTool.QuestionManageTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import CSCI5308.GroupFormationTool.QuestionManage.IQuestionPersistence;
import CSCI5308.GroupFormationTool.QuestionManage.Question;

/**
 * 
 * @author nieruize
 *
 */
public class QuestionDBMock implements IQuestionPersistence  {

	@Override
	public List<Question> loadAllQuestions() {
		List<Question> questionList = new ArrayList<>();
		Question question = new Question();
		question.setId(1);
		question.setTitle("How is going?");
		question.setCreated(new Date(0));
		questionList.add(question);
		question = new Question();
		question.setId(2);
		question.setTitle("Are you finished the assignment?");
		question.setCreated(new Date(1));
		questionList.add(question);
		return questionList;
	}

	@Override
	public void loadQuestionByID(long id, Question question) {
		question.setId(1);
		question.setTitle("How is going?");
		question.setCreated(new Date(0));
	}

	@Override
	public List<Question> sortAllQuestions(String sort) {
		List<Question> questionList = new ArrayList<>();
		Question question1 = new Question();
		question1.setId(1);
		question1.setTitle("How is going?");
		question1.setCreated(new Date(0));
		Question question2 = new Question();
		question2.setId(2);
		question2.setTitle("Are you finished the assignment?");
		question2.setCreated(new Date(1));
		if(sort == "title") {
			questionList.add(question2);
			questionList.add(question1);
		}
		if(sort == "created") {
			questionList.add(question1);
			questionList.add(question2);
		}
		return questionList;
	}

	@Override
	public boolean deleteQuestion(long id) {
		Question question = new Question();
		question.setId(1);
		question.setTitle("How is going?");
		question.setCreated(new Date(0));
		question.setDefaults();
		return true;
	}

}

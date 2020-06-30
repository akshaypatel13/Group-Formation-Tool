package CSCI5308.GroupFormationTool.QuestionManageTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import CSCI5308.GroupFormationTool.AccessControl.User;
import CSCI5308.GroupFormationTool.QuestionManage.IQuestionPersistence;
import CSCI5308.GroupFormationTool.QuestionManage.Options;
import CSCI5308.GroupFormationTool.QuestionManage.Question;

/**
 * 
 * @author nieruize
 *
 */
public class QuestionDBMock implements IQuestionPersistence  {

	@Override
	public List<Question> loadAllQuestions(User user) {
		
		List<Question> questionList = new ArrayList<>();
		
		Question question = new Question();
		question.setId(1);
		question.setTitle("Greeting");
		question.setCreated(new Date(0));
		question.setType("text");
		question.setDescription("How is going?");
		questionList.add(question);
		
		question = new Question();
		question.setId(2);
		question.setTitle("Greeting");
		question.setCreated(new Date(1));
		question.setType("text");
		question.setDescription("Are u ok?");
		questionList.add(question);
		
		return questionList;
	}

	@Override
	public void loadQuestionByID(long id, Question question) {
		
		question.setId(1);
		question.setTitle("Greeting");
		question.setCreated(new Date(0));
		question.setType("text");
		question.setDescription("How is going?");
		
	}

	@Override
	public List<Question> sortQuestionsByTitle(User user) {
		
		List<Question> questionList = new ArrayList<>();
		
		Question question1 = new Question();
		question1.setId(1);
		question1.setTitle("Greeting");
		question1.setCreated(new Date(0));
		question1.setType("text");
		question1.setDescription("How is going?");
		
		Question question2 = new Question();
		question2.setId(2);
		question2.setTitle("Greeting");
		question2.setCreated(new Date(1));
		question2.setType("text");
		question2.setDescription("Are u ok?");
		
		questionList.add(question2);
		questionList.add(question1);
		
		return questionList;
	}
	
	@Override
	public List<Question> sortQuestionsByCreated(User user) {
		
		List<Question> questionList = new ArrayList<>();
		
		Question question1 = new Question();
		question1.setId(1);
		question1.setTitle("Greeting");
		question1.setCreated(new Date(0));
		question1.setType("text");
		question1.setDescription("How is going?");
		
		Question question2 = new Question();
		question2.setId(2);
		question2.setTitle("Greeting");
		question2.setCreated(new Date(1));
		question2.setType("text");
		question2.setDescription("Are u ok?");
		
		questionList.add(question1);
		questionList.add(question2);

		return questionList;
	}


	@Override
	public boolean deleteQuestion(long id) {
		
		Question question = new Question();
		question.setId(1);
		question.setTitle("Greeting");
		question.setCreated(new Date(0));
		question.setType("text");
		question.setDescription("How is going?");
		question.setDefaults();
		
		return true;
	}

	@Override
	public boolean insertQuestion(Question question, User user) {
		question.setTitle("Hello");
		question.setDescription("How are you?");
		question.setType("Numeric");
		question.setCreated(new Date("13/04/2015"));
		question.setInstruct_id(1);
		return true;
	}

	@Override
	public boolean insertOptions(Options options) {
		options.setStoredas(1);
		options.setDescription("Option1");
		return true;
	}

}

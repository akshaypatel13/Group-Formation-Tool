package CSCI5308.GroupFormationTool.QuestionManageTest;


import java.util.Date;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import CSCI5308.GroupFormationTool.QuestionManage.IQuestionPersistence;
import CSCI5308.GroupFormationTool.QuestionManage.Question;

/**
 * 
 * @author nieruize
 *
 */
@SpringBootTest
@SuppressWarnings("deprecation")
public class QuestionTest {

	@Test
	public void ConstructorTests() 
	{
		Question question = new Question();
		Assert.isTrue(question.getId() == -1);
		Assert.isTrue(question.getTitle().isEmpty());
		Assert.isNull(question.getCreated());

		IQuestionPersistence questionDB = new QuestionDBMock();
		question = new Question(1, questionDB);
		Assert.isTrue(question.getId() == 1);
		Assert.isTrue(question.getTitle().equals("How is going?"));
		Assert.isTrue(question.getCreated().equals(new Date(0)));
	}
	
	@Test
	public void setIdTest() 
	{
		Question question = new Question();
		question.setId(7);
		Assert.isTrue(question.getId() == 7);
	}

	@Test
	public void getIdTest() 
	{
		Question question = new Question();
		question.setId(7);
		Assert.isTrue(question.getId() == 7);
	}

	@Test
	public void setTitleTest() 
	{
		Question question = new Question();
		question.setTitle("How is going?");
		Assert.isTrue(question.getTitle().equals("How is going?"));
	}

	@Test
	public void getTitleTest() 
	{
		Question question = new Question();
		question.setTitle("How is going?");
		Assert.isTrue(question.getTitle().equals("How is going?"));
	}
	
	@Test
	public void setCreatedTest() 
	{
		Question question = new Question();
		question.setCreated(new Date(0));
		Assert.isTrue(question.getCreated().equals(new Date(0)));
	}

	@Test
	public void getCreatedTest() 
	{
		Question question = new Question();
		question.setCreated(new Date(0));
		Assert.isTrue(question.getCreated().equals(new Date(0)));
	}

	@Test
	public void deleteCourseTest() 
	{
		IQuestionPersistence questionDB = new QuestionDBMock();
		boolean status = questionDB.deleteQuestion(1);
		Assert.isTrue(status);
	}

}

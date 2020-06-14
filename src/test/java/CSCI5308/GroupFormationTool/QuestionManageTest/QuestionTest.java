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
		Assert.isTrue(question.getType().isEmpty());
		Assert.isTrue(question.getDescription().isEmpty());
		Assert.isNull(question.getCreated());

		IQuestionPersistence questionDB = new QuestionDBMock();
		question = new Question(1, questionDB);
		Assert.isTrue(question.getId() == 1);
		Assert.isTrue(question.getTitle().equals("Greeting"));
		Assert.isTrue(question.getCreated().equals(new Date(0)));
		Assert.isTrue(question.getType().equals("text"));
		Assert.isTrue(question.getDescription().equals("How is going?"));
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
		question.setTitle("Greeting");
		Assert.isTrue(question.getTitle().equals("Greeting"));
	}

	@Test
	public void getTitleTest() 
	{
		Question question = new Question();
		question.setTitle("Greeting");
		Assert.isTrue(question.getTitle().equals("Greeting"));
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
	public void setTypeTest() {
		Question question = new Question();
		question.setType("text");;
		Assert.isTrue(question.getType().equals("text"));
	}
	
	@Test
	public void getTypeTest() {
		Question question = new Question();
		question.setType("text");;
		Assert.isTrue(question.getType().equals("text"));
	}
	
	@Test
	public void getDescriptionTest() {
		Question question = new Question();
		question.setDescription("How is going?");;
		Assert.isTrue(question.getDescription().equals("How is going?"));
	}
	
	@Test
	public void setDescriptionTest() {
		Question question = new Question();
		question.setDescription("How is going?");;
		Assert.isTrue(question.getDescription().equals("How is going?"));
	}

	@Test
	public void deleteCourseTest() 
	{
		IQuestionPersistence questionDB = new QuestionDBMock();
		boolean status = questionDB.deleteQuestion(1);
		Assert.isTrue(status);
	}

}

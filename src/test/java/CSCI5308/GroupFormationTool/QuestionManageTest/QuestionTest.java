package CSCI5308.GroupFormationTool.QuestionManageTest;


import java.util.Date;

import CSCI5308.GroupFormationTool.AccessControl.User;
import CSCI5308.GroupFormationTool.QuestionManage.Options;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import CSCI5308.GroupFormationTool.QuestionManage.IQuestionPersistence;
import CSCI5308.GroupFormationTool.QuestionManage.Question;

import javax.validation.constraints.AssertFalse;

import static org.junit.jupiter.api.Assertions.assertFalse;

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
	public void delete()
	{
		IQuestionPersistence questionDB = new QuestionDBMock();
		boolean status = questionDB.deleteQuestion(1);
		Assert.isTrue(status);
	}

	@Test
	public void insertQuestion(){
		IQuestionPersistence questionDB = new QuestionDBMock();
		Question question=new Question();
		User user=new User();
		questionDB.insertQuestion(question,user);
		Assert.isTrue(question.getTitle().equals("Hello"));
		Assert.isTrue(question.getDescription().equals("How are you?"));
		Assert.isTrue(question.getType().equals("Numeric"));
		Assert.isTrue(question.getCreated().equals(new Date("13/04/2015")));
		Assert.isTrue(question.getInstruct_id()==1);
	}

	@Test
	public void insertQuestionFalse(){
		IQuestionPersistence questionDB = new QuestionDBMock();
		Question question=new Question();
		User user=new User();
		questionDB.insertQuestion(question,user);
		assertFalse(question.getTitle().equals("Hi"));
		assertFalse(question.getDescription().equals("How?"));
		assertFalse(question.getType().equals("Num"));
		assertFalse(question.getCreated().equals(new Date("13/04/2025")));
		assertFalse(question.getInstruct_id()==12);
	}

}

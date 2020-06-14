package CSCI5308.GroupFormationTool.QuestionManageTest;

import org.junit.Test;
import java.util.Date;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import CSCI5308.GroupFormationTool.QuestionManage.IQuestionPersistence;
import CSCI5308.GroupFormationTool.QuestionManage.Question;

/**
 * 
 * @author nieruize
 *
 */
public class QuestionTest {

	@Test
	public void ConstructorTests() 
	{
		Question question = new Question();
		assertTrue(question.getId() == -1);
		assertTrue(question.getTitle().isEmpty());
		assertNull(question.getCreated());

		IQuestionPersistence questionDB = new QuestionDBMock();
		question = new Question(1, questionDB);
		assertTrue(question.getId() == 1);
		assertTrue(question.getTitle().equals("How is going?"));
		assertTrue(question.getCreated().equals(new Date(0)));
	}
	
	@Test
	public void setIdTest() 
	{
		Question question = new Question();
		question.setId(7);
		assertTrue(question.getId() == 7);
	}

	@Test
	public void getIdTest() 
	{
		Question question = new Question();
		question.setId(7);
		assertTrue(question.getId() == 7);
	}

	@Test
	public void setTitleTest() 
	{
		Question question = new Question();
		question.setTitle("How is going?");
		assertTrue(question.getTitle().equals("How is going?"));
	}

	@Test
	public void getTitleTest() 
	{
		Question question = new Question();
		question.setTitle("How is going?");
		assertTrue(question.getTitle().equals("How is going?"));
	}
	
	@Test
	public void setCreatedTest() 
	{
		Question question = new Question();
		question.setCreated(new Date(0));
		assertTrue(question.getCreated().equals(new Date(0)));
	}

	@Test
	public void getCreatedTest() 
	{
		Question question = new Question();
		question.setCreated(new Date(0));
		assertTrue(question.getCreated().equals(new Date(0)));
	}

	@Test
	public void deleteCourseTest() 
	{
		IQuestionPersistence questionDB = new QuestionDBMock();
		boolean status = questionDB.deleteQuestion(1);
		assertTrue(status);
	}

}

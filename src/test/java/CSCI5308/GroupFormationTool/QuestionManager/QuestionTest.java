package CSCI5308.GroupFormationTool.QuestionManager;

import java.sql.Timestamp;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

@SuppressWarnings("deprecation")
public class QuestionTest
{
	@Test
	public void ConstructorTests()
	{
		IQuestion q = QuestionManagerAbstractFactory.instance().createQuestionInstance();
		Assert.isTrue(q.getTitle().isEmpty());
		Assert.isTrue(q.getText().isEmpty());
		Assert.isNull(q.getType());
		Assert.isNull(q.getTimestamp());
	}

	@Test
	public void getTimestamp()
	{
		IQuestion q = QuestionManagerAbstractFactory.instance().createQuestionInstance();
		Timestamp time = Timestamp.valueOf("2020-06-16 00:00:00");
		q.setTimestamp(time);
		Assert.isTrue(time == q.getTimestamp());
	}

	@Test
	public void setTimestamp()
	{
		IQuestion q = QuestionManagerAbstractFactory.instance().createQuestionInstance();
		Timestamp time = Timestamp.valueOf("2020-06-16 00:00:00");
		q.setTimestamp(time);
		Assert.isTrue(time == q.getTimestamp());
	}

	@Test
	public void getId()
	{
		IQuestion q = QuestionManagerAbstractFactory.instance().createQuestionInstance();
		q.setId(7);
		Assert.isTrue(q.getId() == 7);
	}

	@Test
	public void setId()
	{
		IQuestion q = QuestionManagerAbstractFactory.instance().createQuestionInstance();
		q.setId(7);
		Assert.isTrue(q.getId() == 7);
	}

	@Test
	public void getTitle()
	{
		IQuestion q = QuestionManagerAbstractFactory.instance().createQuestionInstance();
		q.setTitle("Test title");
		Assert.isTrue(q.getTitle().equals("Test title"));
	}

	@Test
	public void setTitle()
	{
		IQuestion q = QuestionManagerAbstractFactory.instance().createQuestionInstance();
		q.setTitle("Test title");
		Assert.isTrue(q.getTitle().equals("Test title"));
	}

	@Test
	public void getText()
	{
		IQuestion q = QuestionManagerAbstractFactory.instance().createQuestionInstance();
		q.setText("Test text");
		Assert.isTrue(q.getText().equals("Test text"));
	}

	@Test
	public void setText()
	{
		IQuestion q = QuestionManagerAbstractFactory.instance().createQuestionInstance();
		q.setText("Test text");
		Assert.isTrue(q.getText().equals("Test text"));
	}

	@Test
	public void getType()
	{
		IQuestion q = QuestionManagerAbstractFactory.instance().createQuestionInstance();
		q.setType(QuestionType.TEXT);
		Assert.isTrue(q.getType() == QuestionType.TEXT);
	}

	@Test
	public void setType()
	{
		IQuestion q = QuestionManagerAbstractFactory.instance().createQuestionInstance();
		q.setType(QuestionType.TEXT);
		Assert.isTrue(q.getType() == QuestionType.TEXT);
	}

	@Test
	public void deleteQuestion()
	{
		IQuestion q = QuestionManagerAbstractFactory.instance().createQuestionInstance();
		IQuestionPersistence questionDB = QuestionManagerAbstractFactoryTest.instance().getQuestionPersistence();
		q.setDefaults();
		boolean status = questionDB.deleteQuestionByQuestionId(q.getId());
		Assert.isTrue(status == false);

		q.setId(1);
		q.setTitle("Test title");
		q.setText("Test text");
		q.setType(QuestionType.TEXT);
		q.setTimestamp(Timestamp.valueOf("2020-06-16 00:00:00"));
		status = questionDB.deleteQuestionByQuestionId(q.getId());
		Assert.isTrue(status == true);
	}
}

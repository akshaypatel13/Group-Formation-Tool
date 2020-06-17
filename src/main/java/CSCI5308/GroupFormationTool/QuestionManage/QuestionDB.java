package CSCI5308.GroupFormationTool.QuestionManage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import CSCI5308.GroupFormationTool.AccessControl.User;
import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;

/**
 * 
 * @author nieruize
 *
 */
public class QuestionDB implements IQuestionPersistence {

	@Override
	public void loadQuestionByID(long id, Question question) {
		CallStoredProcedure proc = null;
		try
		{
			proc = new CallStoredProcedure("spFindQuestionByID(?)");
			proc.setParameter(1, id);
			ResultSet results = proc.executeWithResults();
			if (null != results)
			{
				while (results.next())
				{
					String title = results.getString(2);
					String description = results.getString(3);
					String type = results.getString(4);
					Date created = results.getDate(5);

					question.setId(id);
					question.setTitle(title);
					question.setCreated(created);
					question.setType(type);
					question.setDescription(description);

				}
			}
		}
		catch (SQLException e)
		{
			// Logging needed.
		}
		finally
		{
			if (null != proc)
			{
				proc.cleanup();
			}
		}
	}

	@Override
	public List<Question> loadAllQuestions(User user) {
		List<Question> questions = new ArrayList<Question>();
		CallStoredProcedure proc = null;
		try
		{
			proc = new CallStoredProcedure("spLoadAllQuestions(?)");
			proc.setParameter(1, user.getId());
			ResultSet results = proc.executeWithResults();
			if (null != results)
			{
				while (results.next())
				{
					long id = results.getLong(1);
					String title = results.getString(2);
					String description = results.getString(3);
					String type = results.getString(4);
					Date created = results.getDate(5);
					Question q = new Question();
					q.setId(id);
					q.setTitle(title);
					q.setCreated(created);
					q.setType(type);
					q.setDescription(description);
					questions.add(q);
				}
			}
		}
		catch (SQLException e)
		{
			// Logging needed.
		}
		finally
		{
			if (null != proc)
			{
				proc.cleanup();
			}
		}
		return questions;
	}

	@Override
	public List<Question> sortAllQuestions(String sort, User user) {
		List<Question> questions = new ArrayList<Question>();
		CallStoredProcedure proc = null;
		try
		{
			proc = new CallStoredProcedure("spSortAllQuestions(?,?)");
			proc.setParameter(1, sort);
			proc.setParameter(2, user.getId());
			ResultSet results = proc.executeWithResults();
			if (null != results)
			{
				while (results.next())
				{
					long id = results.getLong(1);
					String title = results.getString(2);
					String description = results.getString(3);
					String type = results.getString(4);
					Date created = results.getDate(5);
					Question q = new Question();
					q.setId(id);
					q.setTitle(title);
					q.setCreated(created);
					q.setType(type);
					q.setDescription(description);
					questions.add(q);
				}
			}
		}
		catch (SQLException e)
		{
			// Logging needed.
		}
		finally
		{
			if (null != proc)
			{
				proc.cleanup();
			}
		}

		return questions;
	}

	@Override
	public boolean deleteQuestion(long id) {
		CallStoredProcedure proc = null;
		try
		{
			proc = new CallStoredProcedure("spDeleteQuestion(?)");
			proc.setParameter(1, id);
			proc.execute();
		}
		catch (SQLException e)
		{
			// Logging needed
			return false;
		}
		finally
		{
			if (null != proc)
			{
				proc.cleanup();
			}
		}
		return true;
	}

}

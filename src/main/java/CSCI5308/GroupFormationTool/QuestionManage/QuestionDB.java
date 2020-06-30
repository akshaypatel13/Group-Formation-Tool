package CSCI5308.GroupFormationTool.QuestionManage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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
	public void loadQuestionByID(long id, Question question)
	{
		CallStoredProcedure proc = null;
		try {
			proc = new CallStoredProcedure("spFindQuestionByID(?)");
			proc.setParameter(1, id);
			ResultSet results = proc.executeWithResults();
			if (null != results) {
				while (results.next()) {
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
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
	}

	@Override
	public List<Question> loadAllQuestions(User user)
	{
		List<Question> questions = new ArrayList<Question>();
		CallStoredProcedure proc = null;
		try {
			proc = new CallStoredProcedure("spLoadAllQuestions(?)");
			proc.setParameter(1, user.getId());
			ResultSet results = proc.executeWithResults();
			if (null != results) {
				while (results.next()) {
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
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		return questions;
	}

	@Override
	public List<Question> sortQuestionsByTitle(User user) {
		List<Question> questions = new ArrayList<Question>();
		CallStoredProcedure proc = null;
		try {
			proc = new CallStoredProcedure("spSortQuestionsByTitle(?)");
			proc.setParameter(1, user.getId());
			ResultSet results = proc.executeWithResults();
			if (null != results) {
				while (results.next()) {
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
		} catch (SQLException e) {
			// Logging needed.
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}

		return questions;
	}
	
	@Override
	public List<Question> sortQuestionsByCreated(User user) {
		List<Question> questions = new ArrayList<Question>();
		CallStoredProcedure proc = null;
		try {
			proc = new CallStoredProcedure("spSortQuestionsByCreated(?)");
			proc.setParameter(1, user.getId());
			ResultSet results = proc.executeWithResults();
			if (null != results) {
				while (results.next()) {
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
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}

		return questions;
	}

	@Override
	public boolean deleteQuestion(long id)
	{
		CallStoredProcedure proc = null;
		try {
			proc = new CallStoredProcedure("spDeleteQuestion(?)");
			proc.setParameter(1, id);
			proc.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		return true;
	}

	public boolean insertQuestion(Question question, User user)
	{
		CallStoredProcedure proc = null;
		try {
			proc = new CallStoredProcedure("spInsertQuestion(?, ?, ?, ?, ?, ?)");
			proc.setParameter(1, question.getTitle());
			proc.setParameter(2, question.getDescription());
			proc.setParameter(3, question.getType());
			proc.setParameter(4, LocalDate.now().toString());
			proc.setParameter(5, user.getID());
			proc.registerOutputParameterLong(6);
			proc.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		return true;
	}

	public boolean insertOptions(Options options)
	{
		CallStoredProcedure proc = null;
		try {
			proc = new CallStoredProcedure("spInsertOptions(?, ?)");
			proc.setParameter(1, options.getDescription());
			proc.setParameter(2, options.getStoredAs());
			proc.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		return true;
	}

}

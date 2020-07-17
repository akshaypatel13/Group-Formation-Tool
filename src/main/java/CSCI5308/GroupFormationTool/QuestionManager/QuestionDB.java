package CSCI5308.GroupFormationTool.QuestionManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;
import CSCI5308.GroupFormationTool.Database.DatabaseAbstractFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class QuestionDB implements IQuestionPersistence {
	
	private static final Logger LOG = LogManager.getLogger();
	
	@Override
	public List<IQuestion> loadQuestionsSortedByTitle(String bannerID) {
		List<IQuestion> questionList = new ArrayList<>();
		CallStoredProcedure proc = null;
		try {
			proc = DatabaseAbstractFactory.instance()
					.createCallStoredProcedureInstance("spFindSortedQuestionsByTitle(?)");
			proc.setParameter(1, bannerID);
			ResultSet results = proc.executeWithResults();
			IQuestion question;

			if (null != results) {
				while (results.next()) {
					long id = results.getLong(1);
					String title = results.getString(2);
					String text = results.getString(3);
					QuestionType type = QuestionType.valueOf(results.getString(4).toUpperCase());
					Timestamp timestamp = results.getTimestamp(5);

					question = QuestionManagerAbstractFactory.instance().createQuestionInstance();
					question.setId(id);
					question.setTitle(title);
					question.setText(text);
					question.setType(type);
					question.setTimestamp(timestamp);
					questionList.add(question);
				}
			}

			LOG.info("Operation = loadQuestionsSortedByTitle, Status = Success, RowCount=" + results.getRow());
		} catch (SQLException e) {
			LOG.error("Status = Failed, Error Message=" + e.getMessage());
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		return questionList;
	}

	@Override
	public List<IQuestion> loadSortedQuestionsSortedByDate(String bannerID) {
		List<IQuestion> questionList = new ArrayList<>();
		CallStoredProcedure proc = null;
		try {
			proc = DatabaseAbstractFactory.instance()
					.createCallStoredProcedureInstance("spFindSortedQuestionsByDate(?)");
			proc.setParameter(1, bannerID);
			ResultSet results = proc.executeWithResults();
			IQuestion question;

			if (null != results) {
				while (results.next()) {
					long id = results.getLong(1);
					String title = results.getString(2);
					String text = results.getString(3);
					QuestionType type = QuestionType.valueOf(results.getString(4).toUpperCase());
					Timestamp timestamp = results.getTimestamp(5);

					question = QuestionManagerAbstractFactory.instance().createQuestionInstance();
					question.setId(id);
					question.setTitle(title);
					question.setText(text);
					question.setType(type);
					question.setTimestamp(timestamp);
					questionList.add(question);
				}
			}
			
			LOG.info("Operation = loadSortedQuestionsSortedByDate, Status = Success, RowCount=" + results.getRow());
		} catch (SQLException e) {
			LOG.error("Status = Failed, Error Message=" + e.getMessage());
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		return questionList;
	}

	@Override
	public boolean deleteQuestionByQuestionId(long questionID) {
		CallStoredProcedure proc = null;
		try {
			proc = DatabaseAbstractFactory.instance()
					.createCallStoredProcedureInstance("spDeleteQuestionsByQuestionID(?)");
			proc.setParameter(1, questionID);
			proc.execute();
			LOG.info("Operation = DeleteQuestion, Status = Success, RowCount=" + questionID);
		} catch (SQLException e) {
			LOG.error("Status = Failed, Error Message=" + e.getMessage());
			return false;
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		return true;
	}

	@Override
	public long createQuestion(IQuestion question, String bannerID) {
		long id = -1;
		CallStoredProcedure proc = null;
		try {
			proc = DatabaseAbstractFactory.instance()
					.createCallStoredProcedureInstance("spCreateQuestion(?,?,?,?)");
			proc.setParameter(1, question.getTitle());
			proc.setParameter(2, question.getText());
			proc.setParameter(3, question.getType().toString());
			proc.setParameter(4, bannerID);
			ResultSet results = proc.executeWithResults();

			if (null != results) {
				while (results.next()) {
					id = results.getLong(1);
				}
			}
			LOG.info("Operation = Question Created, Status = Success, QuestionId=" + question.getId());
		} catch (SQLException e) {
			LOG.error("Status = Failed, Error Message=" + e.getMessage());
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		return id;
	}

	@Override
	public boolean createQuestionOption(IOptionValue option, int order, long questionID) {
		CallStoredProcedure proc = null;
		try {
			proc = DatabaseAbstractFactory.instance()
					.createCallStoredProcedureInstance("spCreateOptions(?,?,?,?)");
			proc.setParameter(1, questionID);
			proc.setParameter(2, option.getText());
			proc.setParameter(3, option.getStoredAs());
			proc.setParameter(4, order);
			proc.execute();
			LOG.info("Operation = Question Option Created, Status = Success, OptionsId=" + option.getText());
		} catch (SQLException e) {
			LOG.error("Status = Failed, Error Message=" + e.getMessage());
			return false;
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		return true;
	}

}

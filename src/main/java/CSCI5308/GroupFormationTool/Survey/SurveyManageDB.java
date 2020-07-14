package CSCI5308.GroupFormationTool.Survey;

import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;
import CSCI5308.GroupFormationTool.QuestionManager.IQuestion;
import CSCI5308.GroupFormationTool.QuestionManager.Question;
import CSCI5308.GroupFormationTool.QuestionManager.QuestionManagerAbstractFactory;
import CSCI5308.GroupFormationTool.QuestionManager.QuestionType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class SurveyManageDB implements ISurveyManagePersistence {

    @Override
    public long findSurveyByCourseID(long courseID) {
        CallStoredProcedure proc = null;
        long surveyId = 0;
        try {
            proc = new CallStoredProcedure("spFindSurveyByID(?)");
            proc.setParameter(1, courseID);
            ResultSet results = proc.executeWithResults();
            if (null != results) {
                while (results.next()) {
                    surveyId = results.getLong(1);
                }
            }
        } catch (SQLException e) {
            System.out.print(e);
        } finally {
            if (null != proc) {
                proc.cleanup();
            }
        }
        return surveyId;
    }

    @Override
    public List<IQuestion> findSurveyQuestions(long courseID) {
        List<IQuestion> questionList = new ArrayList<>();
        CallStoredProcedure proc = null;
        try {
            proc = new CallStoredProcedure("spFindSurveyQuestions(?)");
            proc.setParameter(1, courseID);
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
        } catch (SQLException e) {
            System.out.print(e);
        } finally {
            if (null != proc) {
                proc.cleanup();
            }
        }
        return questionList;
    }

    @Override
    public List<IQuestion> findQuestionsNotInSurvey(long userID) {
        List<IQuestion> questionList = new ArrayList<>();
        CallStoredProcedure proc = null;
        try {
            proc = new CallStoredProcedure("spFindQuestionsNotInSurvey(?)");
            proc.setParameter(1, userID);
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
        } catch (SQLException e) {
            System.out.print(e);
        } finally {
            if (null != proc) {
                proc.cleanup();
            }
        }
        return questionList;
    }

    @Override
    public boolean surveyPublishedOrNot(long courseID)
    {
        boolean published = false;
        CallStoredProcedure proc = null;
        try
        {
            proc = new CallStoredProcedure("spFindSurveyPublishedOrNot(?)");
            proc.setParameter(1,courseID);
            ResultSet results = proc.executeWithResults();
            if (null != results)
            {
                if (results.next())
                {
                    published = results.getBoolean(1);
                }
            }
            return !published;
        }
        catch (SQLException e)
        {
            System.out.print(e);
            return false;
        }
        finally
        {
            if (null != proc)
            {
                proc.cleanup();
            }
        }
    }

}

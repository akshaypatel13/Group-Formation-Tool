package CSCI5308.GroupFormationTool.Survey;

import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;
import CSCI5308.GroupFormationTool.QuestionManager.Question;
import CSCI5308.GroupFormationTool.QuestionManager.QuestionType;
import CSCI5308.GroupFormationTool.Response.Response;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public List<Question> findSurveyQuestions(long courseID) {
        List<Question> questionList = new ArrayList<Question>();
        CallStoredProcedure proc = null;
        try {
            proc = new CallStoredProcedure("spFindSurveyQuestions(?)");
            proc.setParameter(1, courseID);
            ResultSet results = proc.executeWithResults();
            Question question;
            if (null != results) {
                while (results.next()) {
                    long id = results.getLong(1);
                    String title = results.getString(2);
                    String text = results.getString(3);
                    QuestionType type = QuestionType.valueOf(results.getString(4).toUpperCase());
                    Timestamp timestamp = results.getTimestamp(5);

                    question = new Question();
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
    public List<Question> findQuestionsNotInSurvey(long userID) {
        List<Question> questionList = new ArrayList<Question>();
        CallStoredProcedure proc = null;
        try {
            proc = new CallStoredProcedure("spFindQuestionsNotInSurvey(?)");
            proc.setParameter(1, userID);
            ResultSet results = proc.executeWithResults();
            Question question;
            if (null != results) {
                while (results.next()) {
                    long id = results.getLong(1);
                    String title = results.getString(2);
                    String text = results.getString(3);
                    QuestionType type = QuestionType.valueOf(results.getString(4).toUpperCase());
                    Timestamp timestamp = results.getTimestamp(5);

                    question = new Question();
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

    @Override
    public Map<Long, Map<Long, String>> getSurveyResponses(long surveyID) {
        CallStoredProcedure proc = null;
        Map<Long, Map<Long, String>> responses = new HashMap<>();
        try
        {
            proc = new CallStoredProcedure("spFindSurveyResponsesBySurveyID(?)");
            proc.setParameter(1,surveyID);
            ResultSet results = proc.executeWithResults();
            if (null != results)
            {
                while (results.next())
                {
                    long questionID = results.getLong(1);
                    long UserID = results.getLong(2);
                    String Response = results.getString(3);
                    System.out.print(questionID);
                    Map<Long, String> questionResponse = responses.getOrDefault(questionID, new HashMap<>());
                    questionResponse.put(UserID, Response);

                    responses.put(questionID, questionResponse);
                }
            }

        }
        catch (SQLException e)
        {
            System.out.print(e);

        }
        finally
        {
            if (null != proc)
            {
                proc.cleanup();
            }
        }

        return responses;
    }

    @Override
    public Map<Long, Long> getSurveyGroupAlgo(long surveyID) {
        CallStoredProcedure proc = null;
        Map<Long, Long> groupAlgo = new HashMap<>();
        try
        {
            proc = new CallStoredProcedure("spFetchSurveyGroupAlgo(?)");
            proc.setParameter(1,surveyID);
            ResultSet results = proc.executeWithResults();
            if (null != results)
            {
                while (results.next())
                {
                    long questionID = results.getLong(1);
                    long algo = results.getLong(2);
                    groupAlgo.put(questionID, algo);

                }
            }

        }
        catch (SQLException e)
        {
            System.out.print(e);

        }
        finally
        {
            if (null != proc)
            {
                proc.cleanup();
            }
        }

        return groupAlgo;
    }
    @Override
    public long getSurveyGroupSize(long surveyID)
    {
        long groupSize = 0;
        CallStoredProcedure proc = null;
        try
        {
            proc = new CallStoredProcedure("spFetchSurveyGroupSize(?)");
            proc.setParameter(1, surveyID);
            ResultSet results = proc.executeWithResults();
            if (null != results)
            {
                if (results.next())
                {
                    groupSize = results.getLong(1);
                }
            }

        }
        catch (SQLException e)
        {
            System.out.print(e);

        }
        finally
        {
            if (null != proc)
            {
                proc.cleanup();
            }
        }
        return groupSize;
    }


}

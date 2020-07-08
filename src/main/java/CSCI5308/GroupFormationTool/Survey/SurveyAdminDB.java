package CSCI5308.GroupFormationTool.Survey;

import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class SurveyAdminDB implements ISurveyAdminPersistence
{

    @Override
    public boolean createSurvey(long courseID) {
        CallStoredProcedure proc = null;
        try
        {
            proc = new CallStoredProcedure("spCreateSurvey(?)");
            proc.setParameter(1,courseID);
            proc.execute();
            return true;
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
    public boolean insertSurveyQuestion(long surveyID, long questionID)
    {
        CallStoredProcedure proc = null;
        try
        {
            proc = new CallStoredProcedure("spInsertSurveyQuestion(?, ?, ?)");
            proc.setParameter(1,surveyID);
            proc.setParameter(2,questionID);
            proc.setParameter(3, LocalDate.now().toString());
            proc.execute();
            return true;
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
    public boolean deleteSurveyQuestion(long questionID)
    {
        CallStoredProcedure proc = null;
        try
        {
            proc = new CallStoredProcedure("spDeleteSurveyQuestion(?)");
            proc.setParameter(1,questionID);
            proc.execute();
            return true;
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
    public boolean publishSurvey(long courseID)
    {
        CallStoredProcedure proc = null;
        try
        {
            proc = new CallStoredProcedure("spPublishSurvey(?)");
            proc.setParameter(1,courseID);
            proc.execute();
            return true;
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
    public boolean disableSurvey(long courseID)
    {
        CallStoredProcedure proc = null;
        try
        {
            proc = new CallStoredProcedure("spDisableSurvey(?)");
            proc.setParameter(1,courseID);
            proc.execute();
            return true;
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

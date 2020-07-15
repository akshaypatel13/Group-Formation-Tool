package CSCI5308.GroupFormationTool.Survey;

import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;
import CSCI5308.GroupFormationTool.QuestionManager.Question;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SurveyAdminDB implements ISurveyAdminPersistence
{
    private static final Logger LOG = LogManager.getLogger();
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
            LOG.error("Status = Failed, Error Message="+e.getMessage());
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
    public boolean insertSurveyQuestion(long surveyID, long questionID, long algo)
    {
        CallStoredProcedure proc = null;
        try
        {
            proc = new CallStoredProcedure("spInsertSurveyQuestion(?, ?, ?, ?)");
            proc.setParameter(1,surveyID);
            proc.setParameter(2,questionID);
            proc.setParameter(3, LocalDate.now().toString());
            proc.setParameter(4, algo);
            proc.execute();
            return true;
        }
        catch (SQLException e)
        {
            LOG.error("Status = Failed, Error Message="+e.getMessage());
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
            LOG.error("Status = Failed, Error Message="+e.getMessage());
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
    public boolean publishSurvey(long courseID, long groupSize)
    {
        CallStoredProcedure proc = null;
        try
        {
            proc = new CallStoredProcedure("spPublishSurvey(?,?)");
            proc.setParameter(1,courseID);
            proc.setParameter(2,groupSize);
            proc.execute();
            return true;
        }
        catch (SQLException e)
        {
            LOG.error("Status = Failed, Error Message="+e.getMessage());
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
            LOG.error("Status = Failed, Error Message="+e.getMessage());
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

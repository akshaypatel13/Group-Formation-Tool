package CSCI5308.GroupFormationTool.PasswordPolicy;

import CSCI5308.GroupFormationTool.AccessControl.User;
import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DefaultPasswordManager implements IPasswordManager
{

    @Override
    public List<String> getPreviousPasswords(User u, int limit)
    {
        List<String> passwords = new ArrayList<>();
        CallStoredProcedure proc = null;
        try
        {
            proc = new CallStoredProcedure("spLoadPreviousPassword(?, ?)");
            System.out.print("id: " + u.getID());
            proc.setParameter(1, u.getID());
            proc.setParameter(2, limit);
            ResultSet results = proc.executeWithResults();
            if (null != results)
            {
                while (results.next())
                {
                    String password = results.getString("previousPassword");
                    passwords.add(password);
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
        return  passwords;
    }
}

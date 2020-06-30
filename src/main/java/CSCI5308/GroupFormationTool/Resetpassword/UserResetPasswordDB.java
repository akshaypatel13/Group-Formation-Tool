package CSCI5308.GroupFormationTool.Resetpassword;

import CSCI5308.GroupFormationTool.AccessControl.User;
import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserResetPasswordDB implements IUserResetPasswordDB {

	@Override
	public void saveUserResetToken(User user)
	{
		long userId = user.getID();
		String resetToken = user.getResetToken();
		CallStoredProcedure proc = null;
		try
		{
			proc = new CallStoredProcedure("spUpdateUserResetToken(?,?)");
			proc.setParameter(1, userId);
			proc.setParameter(2, resetToken);
			proc.execute();
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
	public User findUserByResetToken(String resetToken)
	{
		CallStoredProcedure proc = null;
		User user = new User();
		try
		{
			proc = new CallStoredProcedure("spFindUserByResetToken(?)");
			proc.setParameter(1, resetToken);
			ResultSet results = proc.executeWithResults();
			if (null != results)
			{
				while (results.next())
				{
					long userID = results.getLong(1);
					String bannerID = results.getString(2);
					String password = results.getString(3);
					String firstName = results.getString(4);
					String lastName = results.getString(5);
					String email = results.getString(6);
					user.setID(userID);
					user.setBannerID(bannerID);
					user.setPassword(password);
					user.setFirstName(firstName);
					user.setLastName(lastName);
					user.setEmail(email);
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
		return user;
	}

	@Override
	public void saveUserPassword(User user)
	{
		long userId = user.getID();
		String password = user.getPassword();
		CallStoredProcedure proc = null;
		try
		{
			proc = new CallStoredProcedure("spUpdateUserPassword(?,?)");
			proc.setParameter(1, userId);
			proc.setParameter(2, password);
			proc.execute();
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
}

package CSCI5308.GroupFormationTool.AccessControl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;
import CSCI5308.GroupFormationTool.Database.DatabaseAbstractFactory;

public class UserDB implements IUserPersistence {
	private static final Logger LOG = LogManager.getLogger();

	public void loadUserByID(long id, IUser user) {
		CallStoredProcedure proc = null;
		try {
			proc = DatabaseAbstractFactory.instance().createCallStoredProcedureInstance("spLoadUser(?)");
			proc.setParameter(1, id);
			ResultSet results = proc.executeWithResults();
			if (null != results) {
				while (results.next()) {
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
			LOG.info("Operation = LoadUser, Status = Success, RowCount:" + results.getRow());
		} catch (SQLException e) {
			LOG.error("Status = Failed, Error Message=" + e.getMessage());
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
	}

	public void loadUserByBannerID(String bannerID, IUser user) {
		CallStoredProcedure proc = null;
		long userID = -1;
		try {
			proc = DatabaseAbstractFactory.instance().createCallStoredProcedureInstance("spFindUserByBannerID(?)");
			proc.setParameter(1, bannerID);
			ResultSet results = proc.executeWithResults();
			if (null != results) {
				while (results.next()) {
					userID = results.getLong(1);
				}
			}
			LOG.info("Operation = LoadUserByBannerID, Status = Success, RowCount:" + results.getRow());
		} catch (SQLException e) {
			LOG.error("Status = Failed, Error Message=" + e.getMessage());
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}

		if (userID > -1) {
			loadUserByID(userID, user);
		}
	}

	public boolean createUser(IUser user) {
		CallStoredProcedure proc = null;
		try {
			proc = DatabaseAbstractFactory.instance()
					.createCallStoredProcedureInstance("spCreateUser(?, ?, ?, ?, ?, ?)");
			proc.setParameter(1, user.getBannerID());
			proc.setParameter(2, user.getPassword());
			proc.setParameter(3, user.getFirstName());
			proc.setParameter(4, user.getLastName());
			proc.setParameter(5, user.getEmail());
			proc.registerOutputParameterLong(6);
			proc.execute();
			LOG.info("Operation = User Created, Status = Success, UserID=" + user.getId());
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

	public boolean updateUser(IUser user) {
		return false;
	}
}

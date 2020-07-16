package CSCI5308.GroupFormationTool.PasswordValidation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;
import CSCI5308.GroupFormationTool.Database.DatabaseAbstractFactory;

public class PasswordValidatorDB implements IPasswordValidatorPersistence {
	private static final Logger LOG = LogManager.getLogger();

	@Override
	public HashMap<Long, String> loadActivePasswordValidators() {
		HashMap<Long, String> activeValidators = new HashMap<Long, String>();
		CallStoredProcedure proc = null;
		try {
			proc = DatabaseAbstractFactory.instance()
					.createCallStoredProcedureInstance("spLoadActivePasswordValidators()");
			ResultSet results = proc.executeWithResults();
			if (null != results) {
				while (results.next()) {
					long id = results.getLong(1);
					String name = results.getString(2);
					activeValidators.put(id, name);
				}
			}
			LOG.info("Operation = Loading Active Password Validators, Status = Success, RowCount:" + results.getRow());
		} catch (SQLException e) {
			LOG.error("Status = Failed, Error Message=" + e.getMessage());

		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		return activeValidators;
	}

	@Override
	public String loadConstraintByValidatorId(long id) {
		CallStoredProcedure proc = null;
		String constraint = null;
		try {
			proc =DatabaseAbstractFactory.instance()
					.createCallStoredProcedureInstance("spLoadConstraintByValidator(?)");
			proc.setParameter(1, id);
			ResultSet results = proc.executeWithResults();
			if (null != results) {
				while (results.next()) {
					constraint = results.getString(1);
				}
			}
			LOG.info("Operation = Load Constarint, Status = Success");
		} catch (SQLException e) {
			LOG.error("Status = Failed, Error Message=" + e.getMessage());

		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		return constraint;
	}

	@Override
	public List<String> fetchPreviousPasswordsByBannerID(String bannerID, int constraint) {
		CallStoredProcedure proc = null;
		List<String> passwordList = new ArrayList<String>();
		try {
			proc = DatabaseAbstractFactory.instance()
					.createCallStoredProcedureInstance("spFetchPreviousPasswords(?,?)");
			proc.setParameter(1, bannerID);
			proc.setParameter(2, constraint);
			ResultSet results = proc.executeWithResults();
			if (null != results) {
				while (results.next()) {
					passwordList.add(results.getString(1));
				}
				LOG.info("Operation =Fetching Previous password, Status = Success,BannerId:" +bannerID);
			}
		} catch (SQLException e) {
			LOG.error("Status = Failed, Error Message=" + e.getMessage());

		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		return passwordList;
	}

}

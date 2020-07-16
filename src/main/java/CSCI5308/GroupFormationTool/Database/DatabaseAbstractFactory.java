package CSCI5308.GroupFormationTool.Database;

import java.sql.SQLException;

public class DatabaseAbstractFactory implements IDatabaseAbstractFactory {
	private static DatabaseAbstractFactory uniqueInstance = null;
	private static IDatabaseConfiguration databaseConfig;

	public static DatabaseAbstractFactory instance() {
		if (null == uniqueInstance) {
			uniqueInstance = new DatabaseAbstractFactory();
		}
		return uniqueInstance;
	}

	private DatabaseAbstractFactory() {
		databaseConfig = new DefaultDatabaseConfiguration();
	}

	public IDatabaseConfiguration createDatabaseConfigurationInstance() {
		return databaseConfig;
	}

	public CallStoredProcedure createCallStoredProcedureInstance(String storedProcedureName) {
		try {
			return new CallStoredProcedure(storedProcedureName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}

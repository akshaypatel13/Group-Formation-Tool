package CSCI5308.GroupFormationTool.Database;

public class DatabaseAbstractFactory implements IDatabaseAbstractFactory{
	private static DatabaseAbstractFactory  uniqueInstance = null;
	private static IDatabaseConfiguration databaseConfig;
	

	public static DatabaseAbstractFactory instance() {
		if (null == uniqueInstance) {
			uniqueInstance = new DatabaseAbstractFactory ();
		}
		return uniqueInstance;
	}

	private DatabaseAbstractFactory(){
		databaseConfig = new DefaultDatabaseConfiguration();
	}


	public IDatabaseConfiguration createDatabaseConfigurationInstance() {
		return databaseConfig ;
	}

}

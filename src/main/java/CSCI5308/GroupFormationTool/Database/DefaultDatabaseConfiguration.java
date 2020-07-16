package CSCI5308.GroupFormationTool.Database;

public class DefaultDatabaseConfiguration implements IDatabaseConfiguration
{
	private static final String URL = System.getenv("URL");
	private static final String USER = System.getenv("USER");
	private static final String PASSWORD = System.getenv("PASSWORD");
//
//	private static final String URL = "jdbc:mysql://db-5308.cs.dal.ca/CSCI5308_21_TEST?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
//	private static final String USER = "CSCI5308_21_TEST_USER";
//	private static final String PASSWORD = "CSCI5308_21_TEST_21529";

	public String getDatabaseUserName()
	{
		return USER;
	}

	public String getDatabasePassword()
	{
		return PASSWORD;
	}

	public String getDatabaseURL()
	{
		return URL;
	}
}

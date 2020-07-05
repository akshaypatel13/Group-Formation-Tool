package CSCI5308.GroupFormationTool.QuestionManage;

public class Options
{

	private String description;
	private int storedAs;

	public Options(int storedAs)
	{
		this.storedAs = storedAs;
	}

	public Options() {	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public int getStoredAs()
	{
		return storedAs;
	}

	public void setStoredAs(int storedAs)
	{
		this.storedAs = storedAs;
	}

}

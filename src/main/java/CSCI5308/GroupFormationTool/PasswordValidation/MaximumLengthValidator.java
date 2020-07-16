package CSCI5308.GroupFormationTool.PasswordValidation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MaximumLengthValidator extends PasswordValidator 
{
	private static final Logger LOG = LogManager.getLogger();
	public MaximumLengthValidator(String constraint) 
	{
		this.constraint = constraint;
	}
	
	@Override
	public boolean isValid(String password) 
	{
		int maxLength = Integer.parseInt(this.constraint);
		int passLength = password.length();

		if(passLength>maxLength) 
		{
			LOG.error("Password is violating Maximum Length required policy");
			return false;
		}
		return true;
	}

	@Override
	public String getValidatorName() 
	{
		return PasswordValidatorType.MAXLENGTH.toString();
	}
	 
}

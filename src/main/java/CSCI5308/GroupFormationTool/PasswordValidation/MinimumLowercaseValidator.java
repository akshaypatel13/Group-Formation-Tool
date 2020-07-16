package CSCI5308.GroupFormationTool.PasswordValidation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MinimumLowercaseValidator extends PasswordValidator
{
	private static final Logger LOG = LogManager.getLogger();
	public MinimumLowercaseValidator(String constraint) 
	{
		this.constraint = constraint;
	}
	
	@Override
	public boolean isValid(String password) 
	{
		int minLower = Integer.parseInt(this.constraint);
		int passLower = 0;
		
		for (int i=0; i<password.length(); i++)
		{
			if (Character.isLowerCase(password.charAt(i)))
			{
				passLower++;
			}
		}
		
		if(passLower<minLower) 
		{
			LOG.error("Password is violating Minimum Lowecase Letters equired policy");
			return false;
		}
		
		return true;
	}
	
	@Override
	public String getValidatorName() 
	{
		return PasswordValidatorType.MINLOWERCASE.toString();
	}
	
}

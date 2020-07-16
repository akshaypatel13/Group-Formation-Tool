package CSCI5308.GroupFormationTool.PasswordValidation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MinimumSymbolValidator extends PasswordValidator
{
	private static final Logger LOG = LogManager.getLogger();
	public MinimumSymbolValidator(String constraint) 
	{
		this.constraint = constraint;
	}
	
	@Override
	public boolean isValid(String password) 
	{
		char[] ch = password.toCharArray();
		int minSymbols = Integer.parseInt(this.constraint);
		int passSymbols = 0;
		
		for (int i=0; i<ch.length; i++) 
		{ 
			if(Character.isLetter(ch[i]) == false 
					&& Character.isDigit(ch[i]) == false) 
			{
				passSymbols++;
			}
		} 
		
		if(passSymbols<minSymbols) 
		{
			LOG.error("Password is violating Minimum Symbols required policy");
			return false;
		}
		
		return true;
	}
	
	@Override
	public String getValidatorName() 
	{
		return PasswordValidatorType.MINSYMBOLS.toString();
	}
	
}

package CSCI5308.GroupFormationTool.PasswordValidation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import CSCI5308.GroupFormationTool.AccessControl.User;

public class PasswordValidatorEnumerator implements IPasswordValidatorEnumerator
{	
	private IPasswordValidatorPersistence validatorDB;
	private List<PasswordValidator> activeValidators;
	private HashMap<Long, String> validators;
	private PasswordValidator maximumLengthValidator;
	private PasswordValidator minimumLengthValidator;
	private PasswordValidator minimumLowercaseValidator;
	private PasswordValidator minimumSymbolValidator;
	private PasswordValidator minimumUppercaseValidator;
	private PasswordValidator passwordHistoryValidator;
	
	public PasswordValidatorEnumerator(IPasswordValidatorPersistence validatorDB) 
	{
		this.validatorDB = validatorDB;
		activeValidators = new ArrayList<PasswordValidator>();
		validators = validatorDB.loadActivePasswordValidators();
	}

	public List<PasswordValidator> getActiveValidators(User user)
	{
		System.out.println("Validators active: \n"+validators.values());
		activeValidators = new ArrayList<PasswordValidator>();
		for (@SuppressWarnings("rawtypes") Map.Entry item : validators.entrySet()) 
		{
			long key = (long) item.getKey();
			String value = (String) item.getValue();
			String constraint = validatorDB.loadConstraintByValidatorId(key);
	        
			if(value.equals(PasswordValidatorType.MINLENGTH.toString())) 
	        {
	        	activeValidators.add(PasswordValidationAbstractFactory.instance().createMinimumLengthValidatorInstance());
	        }else if(value.equals(PasswordValidatorType.MAXLENGTH.toString())) 
	        {
	        	activeValidators.add(PasswordValidationAbstractFactory.instance(constraint).createMaximumLengthValidatorInstance());
	        }else if(value.equals(PasswordValidatorType.MINUPPERCASE.toString())) 
	        {
	        	activeValidators.add(PasswordValidationAbstractFactory.instance(constraint).createMinimumUppercaseValidatorInstance());
	        }else if(value.equals(PasswordValidatorType.MINLOWERCASE.toString())) 
	        {
	        	activeValidators.add(PasswordValidationAbstractFactory.instance(constraint).createMinimumLowercaseValidatorInstance());
	        }else if(value.equals(PasswordValidatorType.MINSYMBOLS.toString())) 
	        {
	        	activeValidators.add(PasswordValidationAbstractFactory.instance(constraint).createMinimumSymbolValidatorInstance());
	        }else if(value.equals(PasswordValidatorType.RESTRICTEDCHAR.toString())) 
	        {
	        	activeValidators.add(PasswordValidationAbstractFactory.instance(constraint).createRestrictedCharacterValidatorInstance());
	        }else if(value.equals(PasswordValidatorType.PASSWORDHISTORY.toString())) 
	        {
	        	activeValidators.add(PasswordValidationAbstractFactory.instance(constraint,user).createPasswordHistoryValidator());
	        }   
		}
		
		return activeValidators;
	}
	
}

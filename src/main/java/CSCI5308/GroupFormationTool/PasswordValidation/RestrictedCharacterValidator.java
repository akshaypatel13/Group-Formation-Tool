package CSCI5308.GroupFormationTool.PasswordValidation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RestrictedCharacterValidator extends PasswordValidator {

	private static final Logger LOG = LogManager.getLogger();

	public RestrictedCharacterValidator(String constraint) {
		this.constraint = constraint;
	}

	@Override
	public boolean isValid(String password) {
		char[] restrcitedCharacters = constraint.toCharArray();

		for (int i = 0; i < restrcitedCharacters.length; i++) {
			if (password.contains(String.valueOf(restrcitedCharacters[i]))) {
				LOG.error("Password is violating Restricted Characters policy");
				return false;
			}
		}

		return true;
	}

	@Override
	public String getValidatorName() {
		return PasswordValidatorType.RESTRICTEDCHAR.toString();
	}

}

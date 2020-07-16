package CSCI5308.GroupFormationTool.PasswordValidation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MinimumLengthValidator extends PasswordValidator {
	private static final Logger LOG = LogManager.getLogger();

	public MinimumLengthValidator(String constraint) {
		this.constraint = constraint;
	}

	@Override
	public boolean isValid(String password) {
		int minLength = Integer.parseInt(this.constraint);
		int passLength = password.length();

		if (passLength < minLength) {
			LOG.error("Password is violating Minimum Length required policy");
			return false;
		}
		return true;
	}

	@Override
	public String getValidatorName() {
		return PasswordValidatorType.MINLENGTH.toString();
	}

}

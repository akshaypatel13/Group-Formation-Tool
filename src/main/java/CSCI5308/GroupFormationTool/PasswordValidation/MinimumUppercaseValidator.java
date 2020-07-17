package CSCI5308.GroupFormationTool.PasswordValidation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MinimumUppercaseValidator extends PasswordValidator {
	private static final Logger LOG = LogManager.getLogger();

	public MinimumUppercaseValidator(String constraint) {
		this.constraint = constraint;
	}

	@Override
	public boolean isValid(String password) {
		int minUpper = Integer.parseInt(this.constraint);
		int passUpper = 0;

		for (int i = 0; i < password.length(); i++) {
			if (Character.isUpperCase(password.charAt(i))) {
				passUpper++;
			}
		}

		if (passUpper < minUpper) {
			LOG.error("Password is violating Minimum upper case required policy");
			return false;
		}

		return true;
	}

	@Override
	public String getValidatorName() {
		return PasswordValidatorType.MINUPPERCASE.toString();
	}

}

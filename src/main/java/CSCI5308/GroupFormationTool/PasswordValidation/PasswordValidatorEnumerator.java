package CSCI5308.GroupFormationTool.PasswordValidation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import CSCI5308.GroupFormationTool.AccessControl.IUser;

public class PasswordValidatorEnumerator implements IPasswordValidatorEnumerator {
	private IPasswordValidatorPersistence validatorDB;
	private List<PasswordValidator> activeValidators;
	private HashMap<Long, String> validators;
	private static final Logger LOG = LogManager.getLogger();

	public PasswordValidatorEnumerator(IPasswordValidatorPersistence validatorDB) {
		this.validatorDB = validatorDB;
		activeValidators = new ArrayList<PasswordValidator>();
		validators = validatorDB.loadActivePasswordValidators();
	}

	public List<PasswordValidator> getActiveValidators(IUser user) {

		activeValidators = new ArrayList<PasswordValidator>();
		for (@SuppressWarnings("rawtypes")
		Map.Entry item : validators.entrySet()) {
			long key = (long) item.getKey();
			String value = (String) item.getValue();
			LOG.info("Calling validator DB to fetch security policies");
			String constraint = validatorDB.loadConstraintByValidatorId(key);

			if (value.equals(PasswordValidatorType.MINLENGTH.toString())) {
				activeValidators.add(
						PasswordValidationAbstractFactory.instance().createMinimumLengthValidatorInstance(constraint));
			} else if (value.equals(PasswordValidatorType.MAXLENGTH.toString())) {
				activeValidators.add(
						PasswordValidationAbstractFactory.instance().createMaximumLengthValidatorInstance(constraint));
			} else if (value.equals(PasswordValidatorType.MINUPPERCASE.toString())) {
				activeValidators.add(PasswordValidationAbstractFactory.instance()
						.createMinimumUppercaseValidatorInstance(constraint));
			} else if (value.equals(PasswordValidatorType.MINLOWERCASE.toString())) {
				activeValidators.add(PasswordValidationAbstractFactory.instance()
						.createMinimumLowercaseValidatorInstance(constraint));
			} else if (value.equals(PasswordValidatorType.MINSYMBOLS.toString())) {
				activeValidators.add(
						PasswordValidationAbstractFactory.instance().createMinimumSymbolValidatorInstance(constraint));
			} else if (value.equals(PasswordValidatorType.RESTRICTEDCHAR.toString())) {
				activeValidators.add(PasswordValidationAbstractFactory.instance()
						.createRestrictedCharacterValidatorInstance(constraint));
			} else if (value.equals(PasswordValidatorType.PASSWORDHISTORY.toString())) {
				activeValidators.add(
						PasswordValidationAbstractFactory.instance().createPasswordHistoryValidator(constraint, user));
			}
		}

		return activeValidators;
	}

}

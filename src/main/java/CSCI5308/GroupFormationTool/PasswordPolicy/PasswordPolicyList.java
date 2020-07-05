package CSCI5308.GroupFormationTool.PasswordPolicy;

import CSCI5308.GroupFormationTool.AccessControl.User;

import java.util.ArrayList;

public class PasswordPolicyList implements IPasswordPolicyList {

	private final String MIN_LENGTH = "min_length";
	private final String MIN_LENGTH_ENABLED = "min_length_enabled";

	private final String MAX_LENGTH = "max_length";
	private final String MAX_LENGTH_ENABLED = "max_length_enabled";

	private final String MIN_UPPERCASE_CHARS = "min_uppercase_chars";
	private final String MIN_UPPERCASE_CHARS_ENABLED = "min_uppercase_chars_enabled";

	private final String MIN_LOWERCASE_CHARS = "min_lowercase_chars";
	private final String MIN_LOWERCASE_CHARS_ENABLED = "min_lowercase_chars_enabled";

	private final String MIN_SPECIAL_CHARS = "min_special_chars";
	private final String MIN_SPECIAL_CHARS_ENABLED = "min_special_chars_enabled";

	private final String CHARS_NOT_ALLOWED = "chars_not_allowed";
	private final String CHARS_NOT_ALLOWED_ENABLED = "chars_not_allowed_enabled";

	private static String PASSWORD_HISTORY_ENABLED = "password_history_enabled";
	private static String PASSWORD_HISTORY_COUNT = "password_history_count";

	private ArrayList<PasswordPolicy> policies = new ArrayList<PasswordPolicy>();

	private PasswordPolicy createNewPolicy(String value, String enabled, IPasswordPolicyValidator validator)
	{
		PasswordPolicy policy = new PasswordPolicy();
		policy.setEnabled(enabled);
		policy.setValidator(validator);
		policy.setValue(value);
		return policy;
	}

	@Override
	public ArrayList<PasswordPolicy> getAllPasswordPolicies(User user)
	{
		String minLengthVal = System.getenv(MIN_LENGTH);
		String minLengthEnabled = System.getenv(MIN_LENGTH_ENABLED);

		String maxLengthVal = System.getenv(MAX_LENGTH);
		String maxLengthEnabled = System.getenv(MAX_LENGTH_ENABLED);

		String minUppercaseVal = System.getenv(MIN_UPPERCASE_CHARS);
		String minUppercaseEnabled = System.getenv(MIN_UPPERCASE_CHARS_ENABLED);

		String minLowercaseVal = System.getenv(MIN_LOWERCASE_CHARS);
		String minLowercaseEnabled = System.getenv(MIN_LOWERCASE_CHARS_ENABLED);

		String minSpecialCharacterVal = System.getenv(MIN_SPECIAL_CHARS);
		String minSpecialCharacterEnabled = System.getenv(MIN_SPECIAL_CHARS_ENABLED);

		String CharacterNotAllowedVal = System.getenv(CHARS_NOT_ALLOWED);
		String CharacterNotAllowedEnabled = System.getenv(CHARS_NOT_ALLOWED_ENABLED);

		String passwordHistoryEnabled = System.getenv(System.getenv("password_history_enabled"));
		String passwordHistoryCount = System.getenv(System.getenv("password_history_count"));

		IPasswordPolicyValidator minValidator = new MinLengthValidator(minLengthVal);
		IPasswordPolicyValidator maxValidator = new MaxLengthValidator(maxLengthVal);
		IPasswordPolicyValidator minUppercaseValidator = new MinUppercaseValidator(minUppercaseVal);
		IPasswordPolicyValidator minLowercaseValidator = new MinLowercaseValidator(minLowercaseVal);
		IPasswordPolicyValidator minSpecialCharacterValidator = new MinSpecialCharacterValidator(
				minSpecialCharacterVal);
		IPasswordPolicyValidator CharacterNotAllowedValidator = new CharacterNotAllowedValidator(
				CharacterNotAllowedVal);

		IPasswordPolicyValidator passwordHistoryValidator = new PasswordHistoryValidator(passwordHistoryCount, user);

		PasswordPolicy minPasswordPolicy = createNewPolicy(minLengthVal, minLengthEnabled, minValidator);
		PasswordPolicy maxPasswordPolicy = createNewPolicy(maxLengthVal, maxLengthEnabled, maxValidator);
		PasswordPolicy minUppercasePasswordPolicy = createNewPolicy(minUppercaseVal, minUppercaseEnabled,
				minUppercaseValidator);
		PasswordPolicy minLowercasePasswordPolicy = createNewPolicy(minLowercaseVal, minLowercaseEnabled,
				minLowercaseValidator);
		PasswordPolicy minSpecialCharacterPasswordPolicy = createNewPolicy(minSpecialCharacterVal,
				minSpecialCharacterEnabled, minSpecialCharacterValidator);
		PasswordPolicy CharacterNotAllowedPasswordPolicy = createNewPolicy(CharacterNotAllowedVal,
				CharacterNotAllowedEnabled, CharacterNotAllowedValidator);
		PasswordPolicy HistoryPolicy = createNewPolicy(passwordHistoryCount, passwordHistoryEnabled, passwordHistoryValidator);

		policies.add(maxPasswordPolicy);
		policies.add(minPasswordPolicy);
		policies.add(minUppercasePasswordPolicy);
		policies.add(minLowercasePasswordPolicy);
		policies.add(minSpecialCharacterPasswordPolicy);
		policies.add(CharacterNotAllowedPasswordPolicy);
		policies.add(HistoryPolicy);

		return policies;
	}

}

package CSCI5308.GroupFormationTool.Security;

public class PasswordSecurityPolicyConfig implements IPasswordSecurityPolicyConfig {


	private static String MIN_LENGTH;
	private static String MIN_LENGTH_ENABLED;
	
	private static String MAX_LENGTH;
	private static String MAX_LENGTH_ENABLED;
	
	private static String MIN_UPPERCASE_CHARS;
	private static String MIN_UPPERCASE_CHARS_ENABLED;
	
	private static String MIN_LOWERCASE_CHARS;
	private static String MIN_LOWERCASE_CHARS_ENABLED;
	
	private static String MIN_SPECIAL_CHARS;
	private static String MIN_SPECIAL_CHARS_ENABLED;

	private static String CHARS_NOT_ALLOWED;
	private static String CHARS_NOT_ALLOWED_ENABLED;

	private static String PASSWORD_HISTORY_ENABLED;
	private static String PASSWORD_HISTORY_COUNT;

	public PasswordSecurityPolicyConfig()
	{
		setMinLength(System.getenv("min_length"));
		setMinLengthEnabled(System.getenv("min_length_enabled"));
		
		setMaxLength(System.getenv("max_length"));
		setMaxLengthEnabled(System.getenv("max_length_enabled"));
		
		setMinUppercaseChars(System.getenv("min_uppercase_chars"));
		setMinUppercaseCharsEnabled(System.getenv("min_uppercase_chars_enabled"));
		
		setMinLowercaseChars(System.getenv("min_lowercase_chars"));
		setMinLowercaseCharsEnabled(System.getenv("min_lowercase_chars_enabled"));
		
		setMinSpecialChars(System.getenv("min_special_chars"));
		setMinSpecialCharsEnabled(System.getenv("min_special_chars_enabled"));
		
		setCharsNotAllowed(System.getenv("chars_not_allowed"));
		setCharsNotAllowedEnabled(System.getenv("chars_not_allowed_enabled"));

		setPasswordHistoryCount(System.getenv("password_history_count"));
		setPasswordHistoryEnabled(System.getenv("password_history_enabled"));

	}

	@Override
	public String getMinLength() {
		return MIN_LENGTH;
	}

	@Override
	public void setMinLength(String minLength) {
		MIN_LENGTH = minLength;
	}

	@Override
	public String getMinLengthEnabled() {
		return MIN_LENGTH_ENABLED;
	}

	@Override
	public void setMinLengthEnabled(String minLengthEnabled) {
		MIN_LENGTH_ENABLED = minLengthEnabled;
	}

	@Override
	public String getMaxLength() {
		return MAX_LENGTH;
	}

	@Override
	public void setMaxLength(String maxLength) {
		MAX_LENGTH = maxLength;
	}

	@Override
	public String getMaxLengthEnabled() {
		return MAX_LENGTH_ENABLED;
	}

	@Override
	public void setMaxLengthEnabled(String maxLengthEnabled) {
		MAX_LENGTH_ENABLED = maxLengthEnabled;
	}

	@Override
	public String getMinUppercaseChars() {
		return MIN_UPPERCASE_CHARS;
	}

	@Override
	public void setMinUppercaseChars(String minUppercaseChars) {
		MIN_UPPERCASE_CHARS = minUppercaseChars;
	}

	@Override
	public void setPasswordHistoryCount(String passwordHistoryCount) {
		PASSWORD_HISTORY_COUNT = passwordHistoryCount;
	}

	@Override
	public void setPasswordHistoryEnabled(String passwordHistoryEnabled) {
		PASSWORD_HISTORY_ENABLED = passwordHistoryEnabled;
	}

	@Override
	public String getMinUppercaseCharsEnabled() {
		return MIN_UPPERCASE_CHARS_ENABLED;
	}

	@Override
	public void setMinUppercaseCharsEnabled(String minUppercaseCharsEnabled) {
		MIN_UPPERCASE_CHARS_ENABLED = minUppercaseCharsEnabled;
	}

	@Override
	public String getMinLowercaseChars() {
		return MIN_LOWERCASE_CHARS;
	}

	@Override
	public void setMinLowercaseChars(String minLowercaseChars) {
		MIN_LOWERCASE_CHARS = minLowercaseChars;
	}

	@Override
	public String getMinLowercaseCharsEnabled() {
		return MIN_LOWERCASE_CHARS_ENABLED;
	}

	@Override
	public String getPasswordHistoryEnabled() {
		return PASSWORD_HISTORY_ENABLED;
	}

	@Override
	public String getPasswordHistoryCount() {
		return PASSWORD_HISTORY_COUNT;
	}

	@Override
	public void setMinLowercaseCharsEnabled(String minLowercaseCharsEnabled) {
		MIN_LOWERCASE_CHARS_ENABLED = minLowercaseCharsEnabled;
	}

	@Override
	public String getMinSpecialChars() {
		return MIN_SPECIAL_CHARS;
	}

	@Override
	public void setMinSpecialChars(String minSpecialChars) {
		MIN_SPECIAL_CHARS = minSpecialChars;
	}

	@Override
	public String getMinSpecialCharsEnabled() {
		return MIN_SPECIAL_CHARS_ENABLED;
	}

	@Override
	public void setMinSpecialCharsEnabled(String minSpecialCharsEnabled) {
		MIN_SPECIAL_CHARS_ENABLED = minSpecialCharsEnabled;
	}

	@Override
	public String getCharsNotAllowed() {
		return CHARS_NOT_ALLOWED;
	}

	@Override
	public void setCharsNotAllowed(String charsNotAllowed) {
		CHARS_NOT_ALLOWED = charsNotAllowed;
	}

	@Override
	public String getCharsNotAllowedEnabled() {
		return CHARS_NOT_ALLOWED_ENABLED;
	}

	@Override
	public void setCharsNotAllowedEnabled(String charsNotAllowedEnabled) {
		CHARS_NOT_ALLOWED_ENABLED = charsNotAllowedEnabled;
	}

}

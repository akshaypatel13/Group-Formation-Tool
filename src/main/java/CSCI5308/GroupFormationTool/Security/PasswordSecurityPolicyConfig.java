package CSCI5308.GroupFormationTool.Security;

public class PasswordSecurityPolicyConfig implements IPasswordSecurityPolicyConfig {

//	private static String MIN_LENGTH = "2";
//	private static String MIN_LENGTH_ENABLED = "1";
//	private static String MAX_LENGTH = "8";
//	private static String MAX_LENGTH_ENABLED = "1";
//	private static String MIN_UPPERCASE_CHARS = "1";
//	private static String MIN_UPPERCASE_CHARS_ENABLED = "0";
//	private static String MIN_LOWERCASE_CHARS = "1";
//	private static String MIN_LOWERCASE_CHARS_ENABLED = "0";
//	private static String MIN_SPECIAL_CHARS = "2";
//	private static String MIN_SPECIAL_CHARS_ENABLED = "0";
//	private static String CHARS_NOT_ALLOWED = "#";
//	private static String CHARS_NOT_ALLOWED_ENABLED = "1";

	private static final String MIN_LENGTH = System.getenv("min_length");
	private static final String MIN_LENGTH_ENABLED = System.getenv("min_length_enabled");
	private static final String MAX_LENGTH = System.getenv("max_length");
	private static final String MAX_LENGTH_ENABLED = System.getenv("max_length_enabled");
	private static final String MIN_UPPERCASE_CHARS = System.getenv("min_uppercase_chars");
	private static final String MIN_UPPERCASE_CHARS_ENABLED = System.getenv("min_uppercase_chars_enabled");
	private static final String MIN_LOWERCASE_CHARS = System.getenv("min_lowercase_chars");
	private static final String MIN_LOWERCASE_CHARS_ENABLED = System.getenv("min_lowercase_chars_enabled");
	private static final String MIN_SPECIAL_CHARS = System.getenv("min_special_chars");
	private static final String MIN_SPECIAL_CHARS_ENABLED = System.getenv("min_special_chars_enabled");

	private static final String CHARS_NOT_ALLOWED = System.getenv("chars_not_allowed");
	private static final String CHARS_NOT_ALLOWED_ENABLED = System.getenv("chars_not_allowed_enabled");

	@Override
	public String getMinLength() {
		return MIN_LENGTH;
	}

	@Override
	public String getMinLengthEnabled() {
		return MIN_LENGTH_ENABLED;
	}

	@Override
	public String getMaxLength() {
		return MAX_LENGTH;
	}

	@Override
	public String getMaxLengthEnabled() {
		return MAX_LENGTH_ENABLED;
	}

	@Override
	public String getMinUppercaseChars() {
		return MIN_UPPERCASE_CHARS;
	}

	@Override
	public String getMinUppercaseCharsEnabled() {
		return MIN_UPPERCASE_CHARS_ENABLED;
	}

	@Override
	public String getMinLowercaseChars() {
		return MIN_LOWERCASE_CHARS;
	}

	@Override
	public String getMinLowercaseCharsEnabled() {
		return MIN_LOWERCASE_CHARS_ENABLED;
	}

	@Override
	public String getMinSpecialChars() {
		return MIN_SPECIAL_CHARS;
	}

	@Override
	public String getMinSpecialCharsEnabled() {
		return MIN_SPECIAL_CHARS_ENABLED;
	}

	@Override
	public String getCharsNotAllowed() {
		return CHARS_NOT_ALLOWED;
	}

	@Override
	public String getCharsNotAllowedEnabled() {
		return CHARS_NOT_ALLOWED_ENABLED;
	}

}

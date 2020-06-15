package CSCI5308.GroupFormationTool.AccessControl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordSecurityPolicy implements IPasswordSecurityPolicy {

	// private static final String MIN_LENGTH = System.getenv("5");
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
//	private static final String MIN_LENGTH = "5";
//	private static final String MIN_LENGTH_ENABLED = "1";
//	private static final String MAX_LENGTH = "8";
//	private static final String MAX_LENGTH_ENABLED = "1";
//	private static final String MIN_UPPERCASE_CHARS = "1";
//	private static final String MIN_UPPERCASE_CHARS_ENABLED = "1";
//	private static final String MIN_LOWERCASE_CHARS = "1";
//	private static final String MIN_LOWERCASE_CHARS_ENABLED = "1";
//	private static final String MIN_SPECIAL_CHARS = "2";
//	private static final String MIN_SPECIAL_CHARS_ENABLED = "1";

	private static final String LAST_X_PASSWORDS = "last_x_passwords";
	private static final String LAST_X_PASSWORDS_ENABLED = "last_x_passwords_enabled";

	public String isFollowingSecurityRules(String password) {

		if (Integer.parseInt(MIN_LENGTH_ENABLED) == 1) {
			if (password.length() < Integer.parseInt(MIN_LENGTH)) {
				return "Minimum password length required : " + MIN_LENGTH;
			}
		}
		if (Integer.parseInt(MAX_LENGTH_ENABLED) == 1) {
			if (password.length() > Integer.parseInt(MAX_LENGTH)) {
				return "Maximum password length violated : " + MAX_LENGTH;
			}
		}
		if (Integer.parseInt(MIN_UPPERCASE_CHARS_ENABLED) == 1) {
			int count = 0;
			for (int i = 0; i < password.length(); i++) {
				if (Character.isUpperCase(password.charAt(i))) {
					count++;
				}
			}
			if (count > Integer.parseInt(MIN_UPPERCASE_CHARS)) {
				return "Minimum uppercase characters required in password : " + MIN_UPPERCASE_CHARS;
			}
		}
		if (Integer.parseInt(MIN_LOWERCASE_CHARS_ENABLED) == 1) {
			int count = 0;
			for (int i = 0; i < password.length(); i++) {
				if (Character.isLowerCase(password.charAt(i))) {
					count++;
				}
			}

			if (count < Integer.parseInt(MIN_LOWERCASE_CHARS)) {
				return "Minimum lowercase characters required in password : " + MIN_LOWERCASE_CHARS;
			}
		}
		if (Integer.parseInt(MIN_SPECIAL_CHARS_ENABLED) == 1) {
			int count = 0;
			for (int i = 1; i <= password.length(); i++) {

				if (password.substring(i - 1, i).matches("[^A-Za-z0-9 ]")) {
					count++;
				}
			}

			if (count < Integer.parseInt(MIN_SPECIAL_CHARS)) {
				return "Minimum special characters required : " + MIN_SPECIAL_CHARS;
			}
		}

		return null;
	}

}

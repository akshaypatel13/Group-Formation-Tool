package CSCI5308.GroupFormationTool.PasswordPolicy;

public class MinSpecialCharacterValidator implements IPasswordPolicyValidator {

	private String value;

	public MinSpecialCharacterValidator(String value) {
		this.value = value;
	}

	@Override
	public boolean isPasswordValid(String password) {
		int specialCharCount = 0;

		for (int i = 1; i <= password.length(); i++) {
			if (password.substring(i - 1, i).matches("[^A-Za-z0-9 ]")) {
				specialCharCount++;
			}
		}

		if (specialCharCount < Integer.parseInt(this.value)) {
			return false;
		}

		return true;
	}

}

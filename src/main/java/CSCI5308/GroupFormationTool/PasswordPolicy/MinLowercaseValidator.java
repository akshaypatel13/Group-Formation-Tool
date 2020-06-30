package CSCI5308.GroupFormationTool.PasswordPolicy;

public class MinLowercaseValidator implements IPasswordPolicyValidator {

	private String value;

	public MinLowercaseValidator(String value) {
		this.value = value;
	}

	@Override
	public boolean isPasswordValid(String password) {
		int lowercaseCount = 0;

		for (int i = 0; i < password.length(); i++) {
			if (Character.isLowerCase(password.charAt(i))) {

				lowercaseCount++;
			}
		}

		if (lowercaseCount < Integer.parseInt(this.value)) {
			return false;
		}

		return true;
	}
}

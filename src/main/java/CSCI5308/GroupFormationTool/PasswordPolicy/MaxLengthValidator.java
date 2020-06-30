package CSCI5308.GroupFormationTool.PasswordPolicy;

public class MaxLengthValidator implements IPasswordPolicyValidator {

	private String value;

	public MaxLengthValidator(String value) {
		this.value = value;
	}

	@Override
	public boolean isPasswordValid(String password) {
		if (password.length() > Integer.parseInt(this.value)) {
			return false;
		}
		return true;
	}
}

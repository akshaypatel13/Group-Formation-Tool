package CSCI5308.GroupFormationTool.PasswordPolicy;

public class CharacterNotAllowedValidator implements IPasswordPolicyValidator {

	private String value;

	public CharacterNotAllowedValidator(String value) {
		this.value = value;
	}

	@Override
	public boolean isPasswordValid(String password) {

		for (int i = 0; i < value.length(); i++) {
			if (password != null && password.indexOf(value.charAt(i)) >= 0) {

				return false;
			}
		}
		return true;
	}
}

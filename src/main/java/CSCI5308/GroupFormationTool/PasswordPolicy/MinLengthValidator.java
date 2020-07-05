package CSCI5308.GroupFormationTool.PasswordPolicy;

public class MinLengthValidator implements IPasswordPolicyValidator
{

	private String value;

	public MinLengthValidator(String value) {
		this.value = value;
	}

	@Override
	public boolean isPasswordValid(String password)
	{
		if (password.length() < Integer.parseInt(this.value))
		{
			return false;
		}
		return true;
	}

}

package CSCI5308.GroupFormationTool.PasswordPolicy;

public class MinUppercaseValidator implements IPasswordPolicyValidator
{

	private String value;

	public MinUppercaseValidator(String value) {
		this.value = value;
	}

	@Override
	public boolean isPasswordValid(String password)
	{
		int upperCaseCount = 0;
		for (int i = 0; i < password.length(); i++)
		{
			if (Character.isUpperCase(password.charAt(i)))
			{
				upperCaseCount++;
			}
		}
		if (upperCaseCount < Integer.parseInt(this.value)) {
			return false;
		}
		return true;
	}

}

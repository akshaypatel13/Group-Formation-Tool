package CSCI5308.GroupFormationTool.PasswordPolicy;

public class PasswordPolicy {

	private String value;
	private String enabled;
	private IPasswordPolicyValidator validator;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public IPasswordPolicyValidator getValidator() {
		return validator;
	}

	public void setValidator(IPasswordPolicyValidator validator) {
		this.validator = validator;
	}

}

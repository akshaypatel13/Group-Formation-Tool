package CSCI5308.GroupFormationTool.Security;

public interface IPasswordSecurityPolicyConfig {

	public String getCharsNotAllowedEnabled();

	public  String getCharsNotAllowed();

	public String getMinLength();

	public String getMinLengthEnabled();

	public String getMaxLengthEnabled();

	public String getMinUppercaseChars();

	public String getMinLowercaseChars();

	public String getMinSpecialChars();

	public String getMinSpecialCharsEnabled();

	public String getMaxLength();

	public String getMinUppercaseCharsEnabled();

	public String getMinLowercaseCharsEnabled();

	public void setCharsNotAllowedEnabled(String charsNotAllowedEnabled);

	public void setCharsNotAllowed(String charsNotAllowed);

	public void setMinSpecialCharsEnabled(String minSpecialCharsEnabled);

	public void setMinSpecialChars(String minSpecialChars);

	public void setMinLowercaseCharsEnabled(String minLowercaseCharsEnabled);

	public void setMinLowercaseChars(String minLowercaseChars);

	public void setMinUppercaseCharsEnabled(String minUppercaseCharsEnabled);

	public void setMinLength(String minLength);

	public void setMinLengthEnabled(String minLengthEnabled);

	public void setMaxLength(String maxLength);

	public void setMaxLengthEnabled(String maxLengthEnabled);

	public void setMinUppercaseChars(String minUppercaseChars);

}

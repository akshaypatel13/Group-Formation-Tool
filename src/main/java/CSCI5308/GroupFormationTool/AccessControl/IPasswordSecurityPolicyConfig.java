package CSCI5308.GroupFormationTool.AccessControl;

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

}

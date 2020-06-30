package CSCI5308.GroupFormationTool.AccessControl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import CSCI5308.GroupFormationTool.SystemConfig;
import CSCI5308.GroupFormationTool.Security.IPasswordEncryption;
import CSCI5308.GroupFormationTool.Security.IPasswordSecurityPolicy;

public class User
{
	// This regex comes from here:
	// https://howtodoinjava.com/regex/java-regex-validate-email-address/
	private static final String EMAIL_REGEX = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
	
	private long id;
	private String password;
	private String bannerID;
	private String firstName;
	private String lastName;
	private String email;

	// the reset token would be used when use forget password
	// the reset token will be generate by uuid
	private String resetToken;

	public static String error;
	
	public static String getError() {
		return error;
	}
	public static void setError(String err) {
		error = err;
	}
	public User()
	{
		setDefaults();
	}
	public static boolean isFollowingSecurityRules(String password)
	{	
		IPasswordSecurityPolicy passwordSecurityPolicy = SystemConfig.instance().getIPasswordSecurityPolicy();
		String result = passwordSecurityPolicy.isFollowingSecurityRules(password);
		if(result!= null)
		{
			setError(result);
			return false;
		}
		return true;
	}
	
	public static boolean isNotFollowingSecurityRules(String password)
	{	
		IPasswordSecurityPolicy passwordSecurityPolicy = SystemConfig.instance().getIPasswordSecurityPolicy();
		String result = passwordSecurityPolicy.isFollowingSecurityRules(password);
		if(result== null)
		{
			return true;
		}
		setError(result);
		return false;
	}
	
	public User(long id, IUserPersistence persistence)
	{
		setDefaults();
		persistence.loadUserByID(id, this);
	}
	
	public User(String bannerID, IUserPersistence persistence)
	{
		setDefaults();
		persistence.loadUserByBannerID(bannerID, this);
	}
	
	public void setDefaults()
	{
		id = -1;
		password = "";
		bannerID = "";
		firstName = "";
		lastName = "";
		email = "";
		resetToken = "";
	}
	
	public void setID(long id)
	{
		this.id = id;
	}
	
	public long getID()
	{
		return id;
	}
	
	// These are here for the Thymeleaf / Spring binding nonsense.
	public void setId(long id)
	{
		this.id = id;
	}
	public long getId()
	{
		return id;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setBannerID(String bannerID)
	{
		this.bannerID = bannerID;
	}
	
	public String getBannerID()
	{
		return bannerID;
	}
	// Also here for Thymeleaf nonsense.
	public String getBanner()
	{
		return bannerID;
	}
	
	public void setFirstName(String name)
	{
		firstName = name;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public void setLastName(String name)
	{
		lastName = name;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public String getEmail()
	{
		return email;
	}

	public String getResetToken() {
		return resetToken;
	}

	public void setResetToken(String resetToken) {
		this.resetToken = resetToken;
	}
	
	public boolean isValidUser()
	{
		return id != -1; 
	}
	
	public boolean isInvalidUser()
	{
		return id == -1; 
	}
	
	public boolean createUser(
		IUserPersistence userDB,
		IPasswordEncryption passwordEncryption,
		IUserNotifications notification)
	{
		String rawPassword = password;
		this.password = passwordEncryption.encryptPassword(this.password);
		boolean success = userDB.createUser(this);
		if (success && (null != notification))
		{
			notification.sendUserLoginCredentials(this, rawPassword);
		}
		return success;
	}
	
	public boolean updateUser(IUserPersistence userDB)
	{
		return userDB.updateUser(this);
	}
	
	private static boolean isStringNullOrEmpty(String s)
	{
		if (null == s)
		{
			return true;
		}
		return s.isEmpty();
	}
	
	private static boolean isStringNotNullOrEmpty(String s)
	{
		if (null != s)
		{
			return true;
		}
		return !s.isEmpty();
	}
	
	public static boolean isBannerIDValid(String bannerID)
	{
		return !isStringNullOrEmpty(bannerID);
	}
	
	public static boolean isBannerIDInvalid(String bannerID)
	{
		return !isStringNotNullOrEmpty(bannerID);
	}
		
	public static boolean isFirstNameValid(String name)
	{
		return !isStringNullOrEmpty(name);
	}
	
	public static boolean isFirstNameInvalid(String name)
	{
		return !isStringNotNullOrEmpty(name);
	}
	
	public static boolean isLastNameValid(String name)
	{
		return !isStringNullOrEmpty(name);
	}
	
	public static boolean isLastNameInvalid(String name)
	{
		return !isStringNotNullOrEmpty(name);
	}
	
	public static boolean isEmailValid(String email)
	{
		if (isStringNullOrEmpty(email))
		{
			return false;
		}
		 
		Pattern pattern = Pattern.compile(EMAIL_REGEX);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
	
	public static boolean isEmailInvalid(String email)
	{
		if (isStringNotNullOrEmpty(email))
		{
			return true;
		}
		 
		Pattern pattern = Pattern.compile(EMAIL_REGEX);
		Matcher matcher = pattern.matcher(email);
		return !matcher.matches();
	}
}
package CSCI5308.GroupFormationTool.AccessControl;

import CSCI5308.GroupFormationTool.PasswordValidation.IPasswordValidatorEnumerator;
import CSCI5308.GroupFormationTool.Security.IPasswordEncryption;

import java.util.List;

public interface IUser {

	public void setDefaults();

	public void setID(long id);

	public long getID();

	public void setId(long id);

	public long getId();

	public void setPassword(String password);

	public String getPassword();

	public void setBannerID(String bannerID);

	public String getBannerID();

	public String getBanner();

	public void setFirstName(String name);

	public String getFirstName();

	public void setLastName(String name);

	public String getLastName();

	public void setEmail(String email);

	public String getEmail();

	public boolean isValidUser();

	public boolean createUser(IUserPersistence userDB, IPasswordValidatorEnumerator passwordEnumerator,
			IPasswordEncryption passwordEncryption, IUserNotifications notification, List<String> errorMessages);

	public boolean createUser(IUserPersistence userDB, IPasswordEncryption passwordEncryption,
			IUserNotifications notification);

	public boolean updateUser(IUserPersistence userDB);

	public boolean isStringNullOrEmpty(String s);

	boolean isBannerIDValid(String bannerID);

	boolean isFirstNameValid(String name);

	boolean isLastNameValid(String name);

	boolean isEmailValid(String email);

	public boolean isInValidUser();

}

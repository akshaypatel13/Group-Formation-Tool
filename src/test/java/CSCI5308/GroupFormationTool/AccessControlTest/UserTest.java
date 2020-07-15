package CSCI5308.GroupFormationTool.AccessControlTest;

import CSCI5308.GroupFormationTool.AccessControl.*;

import static org.assertj.core.api.Assertions.assertThat;

import CSCI5308.GroupFormationTool.Security.IPasswordEncryption;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
@SuppressWarnings("deprecation")
public class UserTest implements IUserTest
{

	@Test
	public void ConstructorTests()
	{
		IUser u = UserAbstractFactory.instance().createUserInstance();
		Assert.isTrue(u.getBannerID().isEmpty());
		Assert.isTrue(u.getFirstName().isEmpty());
		Assert.isTrue(u.getLastName().isEmpty());
		Assert.isTrue(u.getEmail().isEmpty());
		IUser user = UserAbstractFactory.instance().createUserInstance();
		IUserDBMock userDBMock = UserAbstractFactoryMock.instance().getUserDBMock();
		user.setBannerID("B00000000");
		user.setPassword("Pass@123");
		user.setFirstName("Rob");
		user.setLastName("Hawkey");
		user.setEmail("rhawkey@dal.ca");
		Assert.isTrue(userDBMock.createUser(user));
		assertThat(user.equals("Z000000")).isFalse();
	}
	
	@Test
	public void setIDTest()
	{
		IUser u = UserAbstractFactory.instance().createUserInstance();
		u.setID(10);
		Assert.isTrue(10 == u.getID());
	}
	
	@Test
	public void getIDTest()
	{
		IUser u = UserAbstractFactory.instance().createUserInstance();
		u.setID(10);
		Assert.isTrue(10 == u.getID());
	}
	
	@Test
	public void setBannerIDTest()
	{
		IUser u = UserAbstractFactory.instance().createUserInstance();
		u.setBannerID("B00000000");
		Assert.isTrue(u.getBannerID().equals("B00000000"));
	}
	
	@Test
	public void getBannerIDTest()
	{
		IUser u = UserAbstractFactory.instance().createUserInstance();
		u.setBannerID("B00000000");
		Assert.isTrue(u.getBannerID().equals("B00000000"));
	}
	
	@Test
	public void setFirstNameTest()
	{
		IUser u = UserAbstractFactory.instance().createUserInstance();
		u.setFirstName("Rob");
		Assert.isTrue(u.getFirstName().equals("Rob"));
	}
	
	@Test
	public void getFirstNameTest()
	{
		IUser u = UserAbstractFactory.instance().createUserInstance();
		u.setFirstName("Rob");
		Assert.isTrue(u.getFirstName().equals("Rob"));
	}

	@Test
	public void setLastNameTest()
	{
		IUser u = UserAbstractFactory.instance().createUserInstance();
		u.setLastName("Hawkey");
		Assert.isTrue(u.getLastName().equals("Hawkey"));
	}

	@Test
	public void getLastNameTest()
	{
		IUser u = UserAbstractFactory.instance().createUserInstance();
		u.setLastName("Hawkey");
		Assert.isTrue(u.getLastName().equals("Hawkey"));
	}
	
	@Test
	public void setEmailTest()
	{
		IUser u = UserAbstractFactory.instance().createUserInstance();
		u.setEmail("rhawkey@dal.ca");
		Assert.isTrue(u.getEmail().equals("rhawkey@dal.ca"));
	}
	
	@Test
	public void getEmailTest()
	{
		IUser u = UserAbstractFactory.instance().createUserInstance();
		u.setEmail("rhawkey@dal.ca");
		Assert.isTrue(u.getEmail().equals("rhawkey@dal.ca"));
	}
	
	@Test
	public void createUser()
	{		
		IUserDBMock userDB = UserAbstractFactoryMock.instance().getUserDBMock();
		IUser user = UserAbstractFactory.instance().createUserInstance();
		userDB.createUser(user);
		Assert.isTrue(user.getId() == 0);
		Assert.isTrue(user.getBannerID().equals("B00000000"));
	}

	@Test
	public void isBannerIDValidTest()
	{
		IUser userInstance = UserAbstractFactory.instance().createUserInstance();
		Assert.isTrue(userInstance.isBannerIDValid("B000000000"));
		assertThat(userInstance.isBannerIDValid(null)).isFalse();
		assertThat(userInstance.isBannerIDValid("")).isFalse();
	}
		
	@Test
	public void isFirstNameValidTest()
	{
		IUser userInstance = UserAbstractFactory.instance().createUserInstance();
		Assert.isTrue(userInstance.isFirstNameValid("rob"));
		assertThat(userInstance.isFirstNameValid(null)).isFalse();
		assertThat(userInstance.isFirstNameValid("")).isFalse();
	}
	
	@Test
	public void isLastNameValidTest()
	{
		IUser userInstance = UserAbstractFactory.instance().createUserInstance();
		Assert.isTrue(userInstance.isLastNameValid("hawkey"));
		assertThat(userInstance.isLastNameValid(null)).isFalse();
		assertThat(userInstance.isLastNameValid("")).isFalse();
	}
	
	@Test
	public void isEmailValidTest()
	{
		IUser userInstance = UserAbstractFactory.instance().createUserInstance();
		Assert.isTrue(userInstance.isEmailValid("rhawkey@dal.ca"));
		assertThat(userInstance.isEmailValid(null)).isFalse();
		assertThat(userInstance.isEmailValid("")).isFalse();
		assertThat(userInstance.isEmailValid("@dal.ca")).isFalse();
		assertThat(userInstance.isEmailValid("rhawkey@")).isFalse();
	}

	public boolean createUserTest(
			IUserDBMock userDB,
			IUserNotifications notification,
			IUser user
	)
	{
		String rawPassword = "password";
		boolean success = userDB.createUser(user);
		if (success && (null != notification))
		{
			notification.sendUserLoginCredentials(user, rawPassword);
		}
		return success;
	}
}

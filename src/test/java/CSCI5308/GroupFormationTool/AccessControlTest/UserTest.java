package CSCI5308.GroupFormationTool.AccessControlTest;

import CSCI5308.GroupFormationTool.AccessControl.*;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

@SuppressWarnings("deprecation")
public class UserTest
{
	@Test
	public void ConstructorTests()
	{
		User u = new User();
		Assert.isTrue(u.getBannerID().isEmpty());
		Assert.isTrue(u.getFirstName().isEmpty());
		Assert.isTrue(u.getLastName().isEmpty());
		Assert.isTrue(u.getEmail().isEmpty());
		
		IUserPersistence userDBMock = new UserDBMock();
		u = new User(1, userDBMock);
		Assert.isTrue(u.getBannerID().equals("B00000000"));
		
		u = new User("B00000000", userDBMock);
		Assert.isTrue(u.getBannerID().equals("B00000000"));
	}
	
	@Test
	public void setIDTest()
	{
		User u = new User();
		u.setID(10);
		Assert.isTrue(10 == u.getID());
	}
	
	@Test
	public void getIDTest()
	{
		User u = new User();
		u.setID(10);
		Assert.isTrue(10 == u.getID());
	}
	
	@Test
	public void setBannerIDTest()
	{
		User u = new User();
		u.setBannerID("B00000000");
		Assert.isTrue(u.getBannerID().equals("B00000000"));
	}
	
	@Test
	public void getBannerIDTest()
	{
		User u = new User();
		u.setBannerID("B00000000");
		Assert.isTrue(u.getBannerID().equals("B00000000"));
	}
	
	@Test
	public void setFirstNameTest()
	{
		User u = new User();
		u.setFirstName("Rob");
		Assert.isTrue(u.getFirstName().equals("Rob"));
	}
	
	@Test
	public void getFirstNameTest()
	{
		User u = new User();
		u.setFirstName("Rob");
		Assert.isTrue(u.getFirstName().equals("Rob"));
	}

	@Test
	public void setLastNameTest()
	{
		User u = new User();
		u.setLastName("Hawkey");
		Assert.isTrue(u.getLastName().equals("Hawkey"));
	}

	@Test
	public void getLastNameTest()
	{
		User u = new User();
		u.setLastName("Hawkey");
		Assert.isTrue(u.getLastName().equals("Hawkey"));
	}
	
	@Test
	public void setEmailTest()
	{
		User u = new User();
		u.setEmail("rhawkey@dal.ca");
		Assert.isTrue(u.getEmail().equals("rhawkey@dal.ca"));
	}
	
	@Test
	public void getEmailTest()
	{
		User u = new User();
		u.setEmail("rhawkey@dal.ca");
		Assert.isTrue(u.getEmail().equals("rhawkey@dal.ca"));
	}
	
	@Test
	public void createUser()
	{		
		IUserPersistence userDB = new UserDBMock();
		User user = new User();
		userDB.createUser(user);
		Assert.isTrue(user.getId() == 0);
		Assert.isTrue(user.getBannerID().equals("B00000000"));
	}

	@Test
	public void isBannerIDValidTest()
	{
		Assert.isTrue(User.isBannerIDValid("B000000000"));
		Assert.isTrue(User.isBannerIDInvalid(null));
		Assert.isTrue(User.isBannerIDInvalid(""));
	}
		
	@Test
	public void isFirstNameValidTest()
	{
		Assert.isTrue(User.isFirstNameValid("rob"));
		Assert.isTrue(User.isFirstNameInvalid(null));
		Assert.isTrue(User.isFirstNameInvalid(""));
	}
	
	@Test
	public void isLastNameValidTest()
	{
		Assert.isTrue(User.isLastNameValid("hawkey"));
		Assert.isTrue(User.isLastNameInvalid(null));
		Assert.isTrue(User.isLastNameInvalid(""));
	}
	
	@Test
	public void isEmailValidTest()
	{
		Assert.isTrue(User.isEmailValid("rhawkey@dal.ca"));
		Assert.isTrue(User.isEmailInvalid(null));
		Assert.isTrue(User.isEmailInvalid(""));
		Assert.isTrue(User.isEmailInvalid("@dal.ca"));
		Assert.isTrue(User.isEmailInvalid("rhawkey@"));
	}

	
	@Test
	public void isFollowingSecurityRulesTest()
	{
		Assert.isTrue(User.isNotFollowingSecurityRules("123"));
		Assert.isTrue(User.isNotFollowingSecurityRules("123iI"));
		Assert.isTrue(User.isNotFollowingSecurityRules("123I@"));
	}
}

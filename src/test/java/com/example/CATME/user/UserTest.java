package com.example.CATME.user;

import java.util.UUID;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
 * User Test Class.
 * @author Ruize Nie
 * @version 1.0
 */

public class UserTest {

	private User createDefaultUser()
	{
		return new User();
	}
	
	@Test
	public void setUserIdTest() {
		User u = createDefaultUser();
		String uuid = UUID.randomUUID().toString().replace("-", "");
		u.setUserId(uuid);
		assertTrue(u.getUserId().equals(uuid));
	}
	
	@Test
	public void getUserIdTest() {
		User u = createDefaultUser();
		String uuid = UUID.randomUUID().toString().replace("-", "");
		u.setUserId(uuid);
		assertTrue(u.getUserId().equals(uuid));
	}
	
	@Test
	public void setBannerIdTest() {
		User u = createDefaultUser();
		u.setUserId("B00123456");
		assertTrue(u.getUserId().equals("B00123456"));
	}
	
	@Test
	public void getBannerIdTest() {
		User u = createDefaultUser();
		u.setUserId("B00123456");
		assertTrue(u.getUserId().equals("B00123456"));
	}
	
	@Test
	public void setFirstNameTest() {
		User u = createDefaultUser();
		u.setFirstName("River");
		assertTrue(u.getFirstName().equals("River"));
	}
	
	@Test
	public void getFirstNameTest() {
		User u = createDefaultUser();
		u.setFirstName("River");
		assertTrue(u.getFirstName().equals("River"));
	}
	
	@Test
	public void setLastNameTest() {
		User u = createDefaultUser();
		u.setLastName("Lebron");
		assertTrue(u.getLastName().equals("Lebron"));
	}
	
	@Test
	public void getLastNameTest() {
		User u = createDefaultUser();
		u.setLastName("Lebron");
		assertTrue(u.getLastName().equals("Lebron"));
	}
	
	@Test
	public void setEmailTest() {
		User u = createDefaultUser();
		u.setEmail("aa123456@dal.ca");
		assertTrue(u.getEmail().equals("aa123456@dal.ca"));
	}
	
	@Test
	public void getEmailTest() {
		User u = createDefaultUser();
		u.setEmail("aa123456@dal.ca");
		assertTrue(u.getEmail().equals("aa123456@dal.ca"));
	}
	
	@Test
	public void setPasswordTest() {
		User u = createDefaultUser();
		u.setPassword("123456");
		assertTrue(u.getPassword().equals("123456"));
	}
	
	@Test
	public void getPasswordTest() {
		User u = createDefaultUser();
		u.setPassword("123456");
		assertTrue(u.getPassword().equals("123456"));
	}
	
	@Test
	public void setResetTokenTest() {
		User u = createDefaultUser();
		String uuid = UUID.randomUUID().toString().replace("-", "");
		u.setResetToken(uuid);
		assertTrue(u.getResetToken().equals(uuid));
	}
	
	@Test
	public void getResetTokenTest() {
		User u = createDefaultUser();
		String uuid = UUID.randomUUID().toString().replace("-", "");
		u.setResetToken(uuid);
		assertTrue(u.getResetToken().equals(uuid));
	}
}

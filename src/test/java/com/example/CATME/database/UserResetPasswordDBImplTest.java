package com.example.CATME.database;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import com.example.CATME.user.User;

/**
 * UserResetPasswordDBImplTest class for unit testing.
 * @author Ruize Nie
 * @version 1.0
 */
public class UserResetPasswordDBImplTest {
	
	private UserResetPasswordDBImpl createDefaultMySqlDB()
	{
		return new UserResetPasswordDBImpl();
	}
	
	@Test
	public void findUserByEmailTest() {
		UserResetPasswordDBImpl userResetPasswordDBImpl = createDefaultMySqlDB();
		User u = userResetPasswordDBImpl.findUserByEmail("admin@dal.ca");
		assertNotNull(u);
	}
	
	@Test
	public void saveUserResetTokenTest() {
		UserResetPasswordDBImpl userResetPasswordDBImpl = createDefaultMySqlDB();
		User u = userResetPasswordDBImpl.findUserByEmail("admin@dal.ca");
		u.setResetToken("test_reset_token");
		userResetPasswordDBImpl.saveUserResetToken(u);
		u = userResetPasswordDBImpl.findUserByResetToken("test_reset_token");
		assertNotNull(u);
	}
	
	@Test
	public void findUserByResetTokenTest() {
		UserResetPasswordDBImpl userResetPasswordDBImpl = createDefaultMySqlDB();
		User u = userResetPasswordDBImpl.findUserByEmail("admin@dal.ca");
		u.setResetToken("test_reset_token");
		String resetToken = "test_reset_token";
		u = userResetPasswordDBImpl.findUserByResetToken(resetToken);
		assertNotNull(u);
	}
	
	@Test
	public void saveUserPasswordTest() {
		UserResetPasswordDBImpl userResetPasswordDBImpl = createDefaultMySqlDB();
		User u = userResetPasswordDBImpl.findUserByEmail("admin@dal.ca");	
		u.setPassword("admin");
		userResetPasswordDBImpl.saveUserPassword(u);
		assertTrue(u.getPassword().equals("admin"));
	}
}

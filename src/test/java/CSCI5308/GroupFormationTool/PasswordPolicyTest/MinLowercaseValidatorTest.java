package CSCI5308.GroupFormationTool.PasswordPolicyTest;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import CSCI5308.GroupFormationTool.PasswordPolicy.MinLowercaseValidator;

@SpringBootTest
public class MinLowercaseValidatorTest {
	
	@SuppressWarnings("deprecation")
	@Test
	public void isPasswordValidTest() {

		MinLowercaseValidator validator = new MinLowercaseValidator("1");
		Assert.isTrue(validator.isPasswordValid("123a"));
		assertFalse(validator.isPasswordValid("123"));

	}


}

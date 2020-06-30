package CSCI5308.GroupFormationTool.PasswordPolicyTest;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import CSCI5308.GroupFormationTool.PasswordPolicy.MinUppercaseValidator;

@SpringBootTest
public class MinUppercaseValidatorTest {

	@SuppressWarnings("deprecation")
	@Test
	public void isPasswordValidTest() {

		MinUppercaseValidator validator = new MinUppercaseValidator("1");
		Assert.isTrue(validator.isPasswordValid("123A"));
		assertFalse(validator.isPasswordValid("123"));

	}

}

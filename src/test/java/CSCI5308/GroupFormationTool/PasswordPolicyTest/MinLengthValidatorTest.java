package CSCI5308.GroupFormationTool.PasswordPolicyTest;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import CSCI5308.GroupFormationTool.PasswordPolicy.MinLengthValidator;

@SpringBootTest
public class MinLengthValidatorTest {

	@SuppressWarnings("deprecation")
	@Test
	public void isPasswordValidTest() {

		MinLengthValidator validator = new MinLengthValidator("3");
		Assert.isTrue(validator.isPasswordValid("123456"));
		assertFalse(validator.isPasswordValid("12"));

	}

}

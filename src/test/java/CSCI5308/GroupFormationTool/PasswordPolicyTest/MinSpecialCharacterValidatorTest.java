package CSCI5308.GroupFormationTool.PasswordPolicyTest;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import CSCI5308.GroupFormationTool.PasswordPolicy.MinSpecialCharacterValidator;

@SpringBootTest
public class MinSpecialCharacterValidatorTest
{

	@SuppressWarnings("deprecation")
	@Test
	public void isPasswordValidTest()
	{
		MinSpecialCharacterValidator validator = new MinSpecialCharacterValidator("1");
		Assert.isTrue(validator.isPasswordValid("123@"));
		assertFalse(validator.isPasswordValid("123"));
	}

}

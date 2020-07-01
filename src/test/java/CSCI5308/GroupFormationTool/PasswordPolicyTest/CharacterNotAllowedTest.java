package CSCI5308.GroupFormationTool.PasswordPolicyTest;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import CSCI5308.GroupFormationTool.PasswordPolicy.CharacterNotAllowedValidator;

@SpringBootTest
public class CharacterNotAllowedTest
{

	@SuppressWarnings("deprecation")
	@Test
	public void isPasswordValidTest()
	{
		CharacterNotAllowedValidator validator = new CharacterNotAllowedValidator("#");
		Assert.isTrue(validator.isPasswordValid("123a"));
		assertFalse(validator.isPasswordValid("123#"));
	}

}

package CSCI5308.GroupFormationTool.PasswordPolicyTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.PasswordPolicy.MaxLengthValidator;
import CSCI5308.GroupFormationTool.PasswordPolicy.PasswordPolicy;

public class PasswordPolicyTest
{

	@Test
	public void getValueTest()
	{
		PasswordPolicy policy = new PasswordPolicy();
		assertNull(policy.getValue());
		policy.setValue("1");
		assertEquals("1", policy.getValue());
	}

	@Test
	public void setValueTest()
	{
		PasswordPolicy policy = new PasswordPolicy();
		policy.setValue("2");
		assertEquals("2", policy.getValue());
	}

	@Test
	public void getEnabledTest()
	{
		PasswordPolicy policy = new PasswordPolicy();
		assertNull(policy.getEnabled());
		policy.setEnabled("0");
		assertEquals("0", policy.getEnabled());

	}

	@Test
	public void setEnabledTest()
	{
		PasswordPolicy policy = new PasswordPolicy();
		policy.setEnabled("4");
		assertEquals("4", policy.getEnabled());

	}

	@Test
	public void getValidatorTest()
	{
		PasswordPolicy policy = new PasswordPolicy();
		assertNull(policy.getValidator());
		policy.setValidator(new MaxLengthValidator("8"));
		assertNotNull(policy.getValidator());

	}

	@Test
	public void setValidatorTest()
	{
		PasswordPolicy policy = new PasswordPolicy();
		policy.setValidator(new MaxLengthValidator("7"));
		assertNotNull(policy.getValidator());

	}
}

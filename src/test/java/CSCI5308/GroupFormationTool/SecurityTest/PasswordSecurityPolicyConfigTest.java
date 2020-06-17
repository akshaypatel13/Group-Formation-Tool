package CSCI5308.GroupFormationTool.SecurityTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import CSCI5308.GroupFormationTool.Security.IPasswordSecurityPolicyConfig;
import CSCI5308.GroupFormationTool.Security.PasswordSecurityPolicyConfig;

@SpringBootTest
public class PasswordSecurityPolicyConfigTest {

	@Test
	public void getMinLengthTest() {
		IPasswordSecurityPolicyConfig policyConfig = new PasswordSecurityPolicyConfig();

		policyConfig.setMinLength("3");
		assertEquals("3", policyConfig.getMinLength());
	}

	@Test
	public void setMinLength() {
		IPasswordSecurityPolicyConfig policyConfig = new PasswordSecurityPolicyConfig();

		policyConfig.setMinLength("4");
		assertEquals("4", policyConfig.getMinLength());

	}

	@Test
	public void getMinLengthEnabled() {
		IPasswordSecurityPolicyConfig policyConfig = new PasswordSecurityPolicyConfig();

		policyConfig.setMinLengthEnabled("1");
		assertEquals("1", policyConfig.getMinLengthEnabled());
	}

	@Test
	public void setMinLengthEnabled() {
		IPasswordSecurityPolicyConfig policyConfig = new PasswordSecurityPolicyConfig();

		policyConfig.setMinLengthEnabled("0");
		assertEquals("0", policyConfig.getMinLengthEnabled());

	}

	@Test
	public void getMaxLength() {
		IPasswordSecurityPolicyConfig policyConfig = new PasswordSecurityPolicyConfig();

		policyConfig.setMaxLength("6");
		assertEquals("6", policyConfig.getMaxLength());

	}

	@Test
	public void setMaxLength() {
		IPasswordSecurityPolicyConfig policyConfig = new PasswordSecurityPolicyConfig();

		policyConfig.setMaxLength("6");
		assertEquals("6", policyConfig.getMaxLength());

	}

	@Test
	public void getMaxLengthEnabled() {
		IPasswordSecurityPolicyConfig policyConfig = new PasswordSecurityPolicyConfig();

		policyConfig.setMaxLengthEnabled("1");
		assertEquals("1", policyConfig.getMaxLengthEnabled());

	}

	@Test
	public void setMaxLengthEnabled() {
		IPasswordSecurityPolicyConfig policyConfig = new PasswordSecurityPolicyConfig();

		policyConfig.setMaxLengthEnabled("0");
		assertEquals("0", policyConfig.getMaxLengthEnabled());
	}

	@Test
	public void getMinUppercaseChars() {
		IPasswordSecurityPolicyConfig policyConfig = new PasswordSecurityPolicyConfig();

		policyConfig.setMinUppercaseChars("2");
		assertEquals("2", policyConfig.getMinUppercaseChars());
	}

	@Test
	public void setMinUppercaseChars() {
		IPasswordSecurityPolicyConfig policyConfig = new PasswordSecurityPolicyConfig();

		policyConfig.setMinUppercaseChars("1");
		assertEquals("1", policyConfig.getMinUppercaseChars());

	}

	@Test
	public void getMinUppercaseCharsEnabled() {
		IPasswordSecurityPolicyConfig policyConfig = new PasswordSecurityPolicyConfig();

		policyConfig.setMinUppercaseCharsEnabled("1");
		assertEquals("1", policyConfig.getMinUppercaseCharsEnabled());

	}

	@Test
	public void setMinUppercaseCharsEnabled() {
		IPasswordSecurityPolicyConfig policyConfig = new PasswordSecurityPolicyConfig();

		policyConfig.setMinUppercaseCharsEnabled("0");
		assertEquals("0", policyConfig.getMinUppercaseCharsEnabled());

	}

	@Test
	public void getMinLowercaseChars() {
		IPasswordSecurityPolicyConfig policyConfig = new PasswordSecurityPolicyConfig();

		policyConfig.setMinLowercaseChars("1");
		assertEquals("1", policyConfig.getMinLowercaseChars());

	}

	@Test
	public void setMinLowercaseChars() {
		IPasswordSecurityPolicyConfig policyConfig = new PasswordSecurityPolicyConfig();

		policyConfig.setMinLowercaseChars("2");
		assertEquals("2", policyConfig.getMinLowercaseChars());
	}

	@Test
	public void getMinLowercaseCharsEnabled() {
		IPasswordSecurityPolicyConfig policyConfig = new PasswordSecurityPolicyConfig();

		policyConfig.setMinLowercaseCharsEnabled("1");
		assertEquals("1", policyConfig.getMinLowercaseCharsEnabled());
	}

	@Test
	public void setMinLowercaseCharsEnabled() {
		IPasswordSecurityPolicyConfig policyConfig = new PasswordSecurityPolicyConfig();

		policyConfig.setMinLowercaseCharsEnabled("1");
		assertEquals("1", policyConfig.getMinLowercaseCharsEnabled());
	}

	@Test
	public void getMinSpecialChars() {
		IPasswordSecurityPolicyConfig policyConfig = new PasswordSecurityPolicyConfig();

		policyConfig.setMinSpecialChars("1");
		assertEquals("1", policyConfig.getMinSpecialChars());
	}

	@Test
	public void setMinSpecialChars() {
		IPasswordSecurityPolicyConfig policyConfig = new PasswordSecurityPolicyConfig();

		policyConfig.setMinSpecialChars("4");
		assertEquals("4", policyConfig.getMinSpecialChars());
	}

	@Test
	public void getMinSpecialCharsEnabled() {
		IPasswordSecurityPolicyConfig policyConfig = new PasswordSecurityPolicyConfig();

		policyConfig.setMinSpecialCharsEnabled("1");
		assertEquals("1", policyConfig.getMinSpecialCharsEnabled());
	}

	@Test
	public void setMinSpecialCharsEnabled() {
		IPasswordSecurityPolicyConfig policyConfig = new PasswordSecurityPolicyConfig();

		policyConfig.setMinSpecialCharsEnabled("0");
		assertEquals("0", policyConfig.getMinSpecialCharsEnabled());

	}

	@Test
	public void getCharsNotAllowed() {
		IPasswordSecurityPolicyConfig policyConfig = new PasswordSecurityPolicyConfig();

		policyConfig.setCharsNotAllowed("#");
		assertEquals("#", policyConfig.getCharsNotAllowed());

	}

	@Test
	public void setCharsNotAllowed() {
		IPasswordSecurityPolicyConfig policyConfig = new PasswordSecurityPolicyConfig();

		policyConfig.setCharsNotAllowed("#");
		assertEquals("#", policyConfig.getCharsNotAllowed());
	}

	@Test
	public void getCharsNotAllowedEnabled() {
		IPasswordSecurityPolicyConfig policyConfig = new PasswordSecurityPolicyConfig();

		policyConfig.setCharsNotAllowedEnabled("1");
		assertEquals("1", policyConfig.getCharsNotAllowedEnabled());
	}

	@Test
	public void setCharsNotAllowedEnabled() {
		IPasswordSecurityPolicyConfig policyConfig = new PasswordSecurityPolicyConfig();

		policyConfig.setCharsNotAllowedEnabled("1");
		assertEquals("1", policyConfig.getCharsNotAllowedEnabled());
	}

}

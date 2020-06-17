package CSCI5308.GroupFormationTool.SecurityTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import CSCI5308.GroupFormationTool.Security.IPasswordSecurityPolicyConfig;
import CSCI5308.GroupFormationTool.Security.PasswordSecurityPolicy;
import CSCI5308.GroupFormationTool.Security.PasswordSecurityPolicyConfig;


@SpringBootTest
public class PasswordSecurityPolicyTest {
	private IPasswordSecurityPolicyConfig passwordConfig;
	@Test
	public void isFollowingSecurityRules()
	{
		String password = "123uU@";
		passwordConfig = mock(PasswordSecurityPolicyConfig.class);
		IPasswordSecurityPolicyConfig passwordConfigMock = new PasswordSecurityPolicyConfigMock();
		PasswordSecurityPolicy passwordSecurityPolicy=mock(PasswordSecurityPolicy.class);
		
		when(passwordConfig.getMinLength()).thenReturn(passwordConfigMock.getMinLength());
		when(passwordConfig.getMinLengthEnabled()).thenReturn(passwordConfigMock.getMinLengthEnabled());
		when(passwordConfig.getMaxLength()).thenReturn(passwordConfigMock.getMaxLength());
		when(passwordConfig.getMaxLengthEnabled()).thenReturn(passwordConfigMock.getMaxLengthEnabled());
		when(passwordConfig.getMinUppercaseChars()).thenReturn(passwordConfigMock.getMinUppercaseChars());
		when(passwordConfig.getMinUppercaseCharsEnabled()).thenReturn(passwordConfigMock.getMinUppercaseCharsEnabled());
		when(passwordConfig.getMinLowercaseChars()).thenReturn(passwordConfigMock.getMinLowercaseChars());
		when(passwordConfig.getMinLowercaseCharsEnabled()).thenReturn(passwordConfigMock.getMinLowercaseCharsEnabled());
		when(passwordConfig.getCharsNotAllowed()).thenReturn(passwordConfigMock.getCharsNotAllowed());
		when(passwordConfig.getCharsNotAllowedEnabled()).thenReturn(passwordConfigMock.getCharsNotAllowedEnabled());
		when(passwordConfig.getMinSpecialChars()).thenReturn(passwordConfigMock.getMinSpecialChars());
		when(passwordConfig.getMinSpecialCharsEnabled()).thenReturn(passwordConfigMock.getMinSpecialCharsEnabled());
		
		assertEquals("1", passwordConfig.getMinLength());
		assertEquals("6", passwordConfig.getMaxLength());
		assertEquals("1", passwordConfig.getMinUppercaseChars());
		assertEquals("1", passwordConfig.getMinLowercaseChars());
		assertEquals("#", passwordConfig.getCharsNotAllowed());
		assertEquals("1", passwordConfig.getMinSpecialChars());
		//returns err which should be null as password satisfies all conditions
		assertNull(passwordSecurityPolicy.isFollowingSecurityRules(password));
		
	}

}

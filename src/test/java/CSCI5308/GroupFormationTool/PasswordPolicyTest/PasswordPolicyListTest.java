package CSCI5308.GroupFormationTool.PasswordPolicyTest;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import CSCI5308.GroupFormationTool.PasswordPolicy.IPasswordPolicyList;
import CSCI5308.GroupFormationTool.PasswordPolicy.PasswordPolicy;
import CSCI5308.GroupFormationTool.PasswordPolicy.PasswordPolicyList;

@SpringBootTest
public class PasswordPolicyListTest {

	@Test
	public void getAllPasswordPoliciesTest() {

		ArrayList<PasswordPolicy> policy = new ArrayList<PasswordPolicy>();
		IPasswordPolicyList passwordPolicyList = mock(PasswordPolicyList.class);
		when(passwordPolicyList.getAllPasswordPolicies()).thenReturn(policy);
		assertTrue(passwordPolicyList.getAllPasswordPolicies().isEmpty());

	}

}

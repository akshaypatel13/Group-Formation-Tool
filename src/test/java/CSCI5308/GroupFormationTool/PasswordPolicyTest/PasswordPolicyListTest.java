package CSCI5308.GroupFormationTool.PasswordPolicyTest;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import CSCI5308.GroupFormationTool.AccessControl.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import CSCI5308.GroupFormationTool.PasswordPolicy.IPasswordPolicyList;
import CSCI5308.GroupFormationTool.PasswordPolicy.PasswordPolicy;
import CSCI5308.GroupFormationTool.PasswordPolicy.PasswordPolicyList;

@SpringBootTest
public class PasswordPolicyListTest {

	@Test
	public void getAllPasswordPoliciesTest() {
		User u = new User();
		u.setId(0);
		u.setPassword("password");
		ArrayList<PasswordPolicy> policy = new ArrayList<PasswordPolicy>();
		IPasswordPolicyList passwordPolicyList = mock(PasswordPolicyList.class);
		when(passwordPolicyList.getAllPasswordPolicies(u)).thenReturn(policy);
		assertTrue(passwordPolicyList.getAllPasswordPolicies(u).isEmpty());
	}

}

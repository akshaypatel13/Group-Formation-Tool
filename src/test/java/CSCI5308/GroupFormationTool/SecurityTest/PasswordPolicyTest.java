package CSCI5308.GroupFormationTool.SecurityTest;

import CSCI5308.GroupFormationTool.AccessControl.IUserPersistence;
import CSCI5308.GroupFormationTool.AccessControl.User;
import CSCI5308.GroupFormationTool.AccessControlTest.UserDBMock;
import CSCI5308.GroupFormationTool.Security.IPasswordManager;
import CSCI5308.GroupFormationTool.Security.PasswordPolicy;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;


@SpringBootTest
@SuppressWarnings("deprecation")
public class PasswordPolicyTest {
    @Test
    public void checkPreviousPasswordTest(){
        IPasswordManager passwordManager = new PasswordManagerMock();
        PasswordPolicy policy = new PasswordPolicy(passwordManager);
        IUserPersistence userDBMock = new UserDBMock();
        User u = new User(1, userDBMock);
        Assert.isTrue(policy.checkPreviousPassword(u));
    }
}


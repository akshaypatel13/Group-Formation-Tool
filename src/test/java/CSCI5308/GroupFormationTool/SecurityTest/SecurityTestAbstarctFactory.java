package CSCI5308.GroupFormationTool.SecurityTest;

import CSCI5308.GroupFormationTool.CoursesTest.CourseAbstractFactoryTest;
import CSCI5308.GroupFormationTool.Security.IPasswordEncryption;

public class SecurityTestAbstarctFactory {

    private static SecurityTestAbstarctFactory uniqueInstance = null;
    private IPasswordEncryption passwordEncryption;

    public static SecurityTestAbstarctFactory instance() {
        if (null == uniqueInstance) {
            uniqueInstance = new SecurityTestAbstarctFactory();
        }
        return uniqueInstance;
    }

    private SecurityTestAbstarctFactory(){
        passwordEncryption = new PasswordEncryptionMock();
    }

    public IPasswordEncryption getPasswordEncryption(){
        return passwordEncryption;
    }
}

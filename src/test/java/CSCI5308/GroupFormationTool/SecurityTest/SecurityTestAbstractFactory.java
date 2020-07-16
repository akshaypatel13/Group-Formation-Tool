package CSCI5308.GroupFormationTool.SecurityTest;

import CSCI5308.GroupFormationTool.Security.IPasswordEncryption;

public class SecurityTestAbstractFactory {

    private static SecurityTestAbstractFactory uniqueInstance = null;
    private IPasswordEncryption passwordEncryption;

    public static SecurityTestAbstractFactory instance() {
        if (null == uniqueInstance) {
            uniqueInstance = new SecurityTestAbstractFactory();
        }
        return uniqueInstance;
    }

    private SecurityTestAbstractFactory(){
        passwordEncryption = new PasswordEncryptionMock();
    }

    public IPasswordEncryption getPasswordEncryption(){
        return passwordEncryption;
    }
}

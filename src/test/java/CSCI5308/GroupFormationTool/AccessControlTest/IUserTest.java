package CSCI5308.GroupFormationTool.AccessControlTest;

import CSCI5308.GroupFormationTool.AccessControl.IUser;
import CSCI5308.GroupFormationTool.AccessControl.IUserNotifications;
import CSCI5308.GroupFormationTool.AccessControl.IUserPersistence;
import CSCI5308.GroupFormationTool.Security.IPasswordEncryption;

public interface IUserTest {
    public void ConstructorTests();
    public void setIDTest();
    public void getIDTest();
    public void setBannerIDTest();
    public void getBannerIDTest();
    public void setFirstNameTest();
    public void getFirstNameTest();
    public void setLastNameTest();
    public void getLastNameTest();
    public void setEmailTest();
    public void getEmailTest();
    public void createUser();
    public void isBannerIDValidTest();
    public void isFirstNameValidTest();
    public void isLastNameValidTest();
    public void isEmailValidTest();
    public boolean createUserTest(
            IUserDBMock userDB,
            IUserNotifications notification,
            IUser user
    );
}

package CSCI5308.GroupFormationTool.AccessControlTest;

import CSCI5308.GroupFormationTool.AccessControl.IUserPersistence;

public class UserAbstractFactoryMock {

    private static UserAbstractFactoryMock uniqueInstance = null;
    private IUserPersistence userDBMock;

    public static UserAbstractFactoryMock instance() {
        if (null == uniqueInstance) {
            uniqueInstance = new UserAbstractFactoryMock();
        }
        return uniqueInstance;
    }

    private UserAbstractFactoryMock(){
        userDBMock = new UserDBMock();
    }

    public CurrentUserMock getCurrentUserMock(){
        return new CurrentUserMock();
    }

    public IUserPersistence getUserDBMock() { return userDBMock;}


}

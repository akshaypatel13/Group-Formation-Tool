package CSCI5308.GroupFormationTool.AccessControlTest;

public class UserAbstractFactoryMock {

    private static UserAbstractFactoryMock uniqueInstance = null;
    private IUserDBMock userDBMock;

    public static UserAbstractFactoryMock instance() {
        if (null == uniqueInstance) {
            uniqueInstance = new UserAbstractFactoryMock();
        }
        return uniqueInstance;
    }

    private UserAbstractFactoryMock(){
        userDBMock = new UserDBMock();
    }

    public ICurrentUserMock getCurrentUserMock(){
        return new CurrentUserMock();
    }

    public IUserDBMock getUserDBMock() { return userDBMock;}

    public IUserTest getUser() { return new UserTest(); }


}

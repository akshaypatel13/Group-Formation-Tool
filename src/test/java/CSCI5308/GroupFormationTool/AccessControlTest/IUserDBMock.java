package CSCI5308.GroupFormationTool.AccessControlTest;

import CSCI5308.GroupFormationTool.AccessControl.IUser;

public interface IUserDBMock {
    public void loadUserByID(long id, IUser user);
    public void loadUserByBannerID(String bannerID, IUser user);
    public boolean createUser(IUser user);
    public boolean updateUser(IUser user);
}

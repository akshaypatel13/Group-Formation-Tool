package CSCI5308.GroupFormationTool.AccessControlTest;

import CSCI5308.GroupFormationTool.AccessControl.IUser;

public interface ICurrentUserMock {
    public IUser getCurrentAuthenticatedUser();
}

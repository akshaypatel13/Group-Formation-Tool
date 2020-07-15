package CSCI5308.GroupFormationTool.AccessControlTest;

import CSCI5308.GroupFormationTool.AccessControl.IUser;
import CSCI5308.GroupFormationTool.AccessControl.IUserPersistence;
import CSCI5308.GroupFormationTool.AccessControl.User;
import CSCI5308.GroupFormationTool.AccessControl.UserAbstractFactory;

public class CurrentUserMock implements ICurrentUserMock
{
	public IUser getCurrentAuthenticatedUser()
	{
		IUserPersistence userDB = UserAbstractFactory.instance().createUserDBInstance();
		String bannerID = "B00000000";
		IUser u = UserAbstractFactory.instance().createUserInstance();
		userDB.loadUserByBannerID(bannerID, u);
		return u;
	}

}

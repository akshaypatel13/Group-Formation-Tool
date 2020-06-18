package CSCI5308.GroupFormationTool.AccessControlTest;

import CSCI5308.GroupFormationTool.AccessControl.IUserNotifications;
import CSCI5308.GroupFormationTool.AccessControl.User;

public class UserNotificationsMock implements IUserNotifications {
    @Override
    public void sendUserLoginCredentials(User user, String rawPassword) {
        //Email Test
        return;
    }
}

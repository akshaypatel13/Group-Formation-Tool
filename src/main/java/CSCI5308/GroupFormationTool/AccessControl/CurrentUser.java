package CSCI5308.GroupFormationTool.AccessControl;

import CSCI5308.GroupFormationTool.SystemConfig;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class CurrentUser {
    private static CurrentUser uniqueInstance = null;
    IUserPersistence userDB;
    IUserAbstractFactory userAbstractFactory;

    private CurrentUser() {
        userDB = SystemConfig.instance().getUserDB();
        userAbstractFactory = SystemConfig.instance().getUserAbstractFactory();
    }

    public static CurrentUser instance() {
        if (null == uniqueInstance) {
            uniqueInstance = new CurrentUser();
        }
        return uniqueInstance;
    }

    public IUser getCurrentAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.isAuthenticated()) {
            String bannerID = authentication.getPrincipal().toString();
            IUser u = userAbstractFactory.createUserInstance();
            userDB.loadUserByBannerID(bannerID, u);
            if (u.isValidUser()) {
                return u;
            }
        }
        return null;
    }
}

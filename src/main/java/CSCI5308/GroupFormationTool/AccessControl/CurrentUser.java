package CSCI5308.GroupFormationTool.AccessControl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class CurrentUser {

	private static CurrentUser uniqueInstance = null;
	IUserPersistence userDB;
	private static final Logger LOG = LogManager.getLogger();

	private CurrentUser() {
		userDB = UserAbstractFactory.instance().createUserDBInstance();
	}

	public static CurrentUser instance() {
		if (null == uniqueInstance) {
			uniqueInstance = new CurrentUser();
		}
		return uniqueInstance;
	}

	public IUser getCurrentAuthenticatedUser() {
		LOG.info("Calling security Context Holder to check if user is authenticated");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication.isAuthenticated()) {
			LOG.info("checking if current user is Valid user");
			String bannerID = authentication.getPrincipal().toString();
			IUser u = UserAbstractFactory.instance().createUserInstance();
			userDB.loadUserByBannerID(bannerID, u);
			if (u.isValidUser()) {
				return u;
			}
		}
		return null;
	}

}

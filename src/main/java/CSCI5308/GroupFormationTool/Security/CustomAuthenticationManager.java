package CSCI5308.GroupFormationTool.Security;

import java.util.ArrayList;
import java.util.List;

import CSCI5308.GroupFormationTool.Courses.Role;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import CSCI5308.GroupFormationTool.AccessControl.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class CustomAuthenticationManager implements AuthenticationManager {
	private static final String ADMIN_BANNER_ID = "B-000000";
	private static final String BAD_CREDENTIAL_EXCEPTION = "1001";
	private static final String AUTH_SERVICE_EXCEPTION = "1000";
	private static final String USER = "USER";
	private static final Logger LOG = LogManager.getLogger();

	public CustomAuthenticationManager() {
	}

	private Authentication checkAdmin(String password, IUser u, Authentication authentication)
			throws AuthenticationException {

		if (password.equals(u.getPassword())) {
			LOG.info("Admin authentication successful");
			List<GrantedAuthority> rights = new ArrayList<GrantedAuthority>();
			rights.add(new SimpleGrantedAuthority(Role.ADMIN.toString().toUpperCase()));
			UsernamePasswordAuthenticationToken token;
			token = new UsernamePasswordAuthenticationToken(authentication.getPrincipal(),
					authentication.getCredentials(), rights);
			return token;
		} else {
			LOG.error("Admin authentication failed");
			throw new BadCredentialsException(BAD_CREDENTIAL_EXCEPTION);
		}
	}

	private Authentication checkNormal(String password, IUser u, Authentication authentication)
			throws AuthenticationException {
		IPasswordEncryption passwordEncryption = SecurityAbstractFactory.instance().createBCryptPasswordEncryption();
		if (passwordEncryption.matches(password, u.getPassword())) {
			LOG.info("Encrypted password match successful");
			List<GrantedAuthority> rights = new ArrayList<GrantedAuthority>();
			rights.add(new SimpleGrantedAuthority(USER));

			UsernamePasswordAuthenticationToken token;
			token = new UsernamePasswordAuthenticationToken(authentication.getPrincipal(),
					authentication.getCredentials(), rights);
			return token;
		} else {
			LOG.error("Encrypted Password Authentication failed");
			throw new BadCredentialsException(BAD_CREDENTIAL_EXCEPTION);
		}
	}

	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String bannerID = authentication.getPrincipal().toString();
		String password = authentication.getCredentials().toString();
		IUserPersistence userDB = UserAbstractFactory.instance().createUserDBInstance();
		IUser u;
		try {
			u = UserAbstractFactory.instance().createUserParamInstance(bannerID, userDB);
		} catch (Exception e) {
			throw new AuthenticationServiceException(AUTH_SERVICE_EXCEPTION);
		}
		if (u.isValidUser()) {
			LOG.info("User Authentication successful for user:" + u.getBannerID());
			if (bannerID.toUpperCase().equals(ADMIN_BANNER_ID)) {
				return checkAdmin(password, u, authentication);
			} else {
				return checkNormal(password, u, authentication);
			}
		} else {
			LOG.error("User Authentication failed for user:" + u.getBannerID());
			throw new BadCredentialsException(BAD_CREDENTIAL_EXCEPTION);
		}
	}
}

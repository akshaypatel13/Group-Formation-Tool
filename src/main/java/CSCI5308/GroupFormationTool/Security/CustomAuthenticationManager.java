package CSCI5308.GroupFormationTool.Security;

import java.util.ArrayList;
import java.util.List;

import CSCI5308.GroupFormationTool.Courses.Role;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import CSCI5308.GroupFormationTool.SystemConfig;
import CSCI5308.GroupFormationTool.AccessControl.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class CustomAuthenticationManager implements AuthenticationManager {
	private static final String ADMIN_BANNER_ID = "B-000000";
	private static final String BADCREDENTIALEXCEPTION = "1001";
	public CustomAuthenticationManager() {
	}

	private Authentication checkAdmin(String password, User u, Authentication authentication)
			throws AuthenticationException {

		if (password.equals(u.getPassword()))
		{
			List<GrantedAuthority> rights = new ArrayList<GrantedAuthority>();
			rights.add(new SimpleGrantedAuthority(Role.ADMIN.toString().toUpperCase()));
			UsernamePasswordAuthenticationToken token;
			token = new UsernamePasswordAuthenticationToken(authentication.getPrincipal(),
					authentication.getCredentials(),
					rights);
			return token;
		}
		else
		{
			throw new BadCredentialsException(BADCREDENTIALEXCEPTION);
		}
	}
	private Authentication checkNormal(String password, User u, Authentication authentication)
			throws AuthenticationException {
		IPasswordEncryption passwordEncryption = SecurityAbstractFactory.instance().createBCryptPasswordEncryption();
		if (passwordEncryption.matches(password, u.getPassword())) {

			List<GrantedAuthority> rights = new ArrayList<GrantedAuthority>();
			rights.add(new SimpleGrantedAuthority("USER"));

			UsernamePasswordAuthenticationToken token;
			token = new UsernamePasswordAuthenticationToken(authentication.getPrincipal(),
					authentication.getCredentials(),
					rights);
			return token;
		} else {
			throw new BadCredentialsException(BADCREDENTIALEXCEPTION);
		}
	}

	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String bannerID = authentication.getPrincipal().toString();
		String password = authentication.getCredentials().toString();
		IUserPersistence userDB = UserAbstractFactory.instance().createUserDBInstance();
		User u;
		try {
			u = new User(bannerID, userDB);
		} catch (Exception e) {
			throw new AuthenticationServiceException("1000");
		}
		if (u.isValidUser()) {
			if (bannerID.toUpperCase().equals(ADMIN_BANNER_ID)) {
				return checkAdmin(password, u, authentication);
			} else {
				return checkNormal(password, u, authentication);
			}
		} else {

			throw new BadCredentialsException(BADCREDENTIALEXCEPTION);
		}
	}
}

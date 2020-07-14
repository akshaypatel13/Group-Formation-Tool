package CSCI5308.GroupFormationTool.Security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SecurityAbstractFactory implements ISecurityAbstractFactory {

	@Override
	public BCryptPasswordEncoder createBCryptPasswordEncoderInstance() {
		return new BCryptPasswordEncoder();
	}

	public UsernamePasswordAuthenticationToken createUsernamePasswordAuthenticationToken(Authentication authentication,
			List<GrantedAuthority> rights) {
		return new UsernamePasswordAuthenticationToken(authentication.getPrincipal(), authentication.getCredentials(),
				rights);
	}

	@Override
	public ArrayList<GrantedAuthority> createArrayList() {
		return new ArrayList<GrantedAuthority>();
	}

	@Override
	public SimpleGrantedAuthority createSimpleGrantedAuthority(String role) {
		return new SimpleGrantedAuthority(role);
	}

	@Override
	public CustomAuthenticationManager createCustomAuthenticationManager() {
		return new CustomAuthenticationManager();
	}

	@Override
	public BCryptPasswordEncryption createBCryptPasswordEncryption() {
		return new BCryptPasswordEncryption();
	}



}

package CSCI5308.GroupFormationTool.Security;

import java.util.ArrayList;
import java.util.List;

import CSCI5308.GroupFormationTool.QuestionManager.QuestionManagerAbstractFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SecurityAbstractFactory {

	private static SecurityAbstractFactory uniqueInstance = null;
	private IPasswordEncryption passwordEncryption;

	public static SecurityAbstractFactory instance() {
		if (null == uniqueInstance) {
			uniqueInstance = new SecurityAbstractFactory();
		}
		return uniqueInstance;
	}

	private SecurityAbstractFactory(){
		passwordEncryption = new BCryptPasswordEncryption();
	}


	public BCryptPasswordEncoder createBCryptPasswordEncoderInstance() {
		return new BCryptPasswordEncoder();
	}

	public UsernamePasswordAuthenticationToken createUsernamePasswordAuthenticationToken(Authentication authentication,
			List<GrantedAuthority> rights) {
		return new UsernamePasswordAuthenticationToken(authentication.getPrincipal(), authentication.getCredentials(),
				rights);
	}

	public ArrayList<GrantedAuthority> createArrayList() {
		return new ArrayList<GrantedAuthority>();
	}

	public SimpleGrantedAuthority createSimpleGrantedAuthority(String role) {
		return new SimpleGrantedAuthority(role);
	}


	public CustomAuthenticationManager createCustomAuthenticationManager() {
		return new CustomAuthenticationManager();
	}


	public IPasswordEncryption createBCryptPasswordEncryption(){ return passwordEncryption;}


}

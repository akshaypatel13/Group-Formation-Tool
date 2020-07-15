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


	public IPasswordEncryption createBCryptPasswordEncryption(){ return passwordEncryption;}


}

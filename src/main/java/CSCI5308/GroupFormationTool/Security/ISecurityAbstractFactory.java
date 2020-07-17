package CSCI5308.GroupFormationTool.Security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public interface ISecurityAbstractFactory {

	public BCryptPasswordEncoder createBCryptPasswordEncoderInstance();

	public UsernamePasswordAuthenticationToken createUsernamePasswordAuthenticationToken(Authentication authentication,
			List<GrantedAuthority> rights);

	public ArrayList<GrantedAuthority> createArrayList();

	public SimpleGrantedAuthority createSimpleGrantedAuthority(String role);
	
	public  CustomAuthenticationManager createCustomAuthenticationManager();
	
	public BCryptPasswordEncryption createBCryptPasswordEncryption();

}

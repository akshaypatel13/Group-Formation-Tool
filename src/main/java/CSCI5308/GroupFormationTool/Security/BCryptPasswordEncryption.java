package CSCI5308.GroupFormationTool.Security;

import org.springframework.security.crypto.bcrypt.*;

import CSCI5308.GroupFormationTool.SystemConfig;

public class BCryptPasswordEncryption implements IPasswordEncryption
{
	private BCryptPasswordEncoder encoder;
	private ISecurityAbstractFactory securityAbstractFactory;
	
	public String encryptPassword(String rawPassword)
	{
		securityAbstractFactory = SystemConfig.instance().getSecurityAbstractFactory();
		encoder =securityAbstractFactory.createBCryptPasswordEncoderInstance();		
		return encoder.encode(rawPassword);
	}
	
	public boolean matches(String rawPassword, String encryptedPassword)
	{
		securityAbstractFactory = SystemConfig.instance().getSecurityAbstractFactory();
		encoder =securityAbstractFactory.createBCryptPasswordEncoderInstance();
		return encoder.matches(rawPassword, encryptedPassword);
	}
}

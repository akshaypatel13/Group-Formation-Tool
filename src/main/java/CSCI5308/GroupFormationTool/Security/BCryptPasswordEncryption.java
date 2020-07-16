package CSCI5308.GroupFormationTool.Security;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.crypto.bcrypt.*;

public class BCryptPasswordEncryption implements IPasswordEncryption
{
	private BCryptPasswordEncoder encoder;
	private static final Logger LOG = LogManager.getLogger();

	public BCryptPasswordEncryption()
	{
		encoder = new BCryptPasswordEncoder();
	}

	public String encryptPassword(String rawPassword)
	{
		LOG.info("Encrypt password using Bcrypt Encryptor");
		return encoder.encode(rawPassword);
	}

	public boolean matches(String rawPassword, String encryptedPassword)
	{
		LOG.info("Check if password plain text matches with encrypted password");
		return encoder.matches(rawPassword, encryptedPassword);
	}
}

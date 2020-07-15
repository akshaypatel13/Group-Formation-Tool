package CSCI5308.GroupFormationTool.Security;

public class SecurityAbstractFactory {

	private static SecurityAbstractFactory uniqueInstance = null;
	private IPasswordEncryption passwordEncryption;

	public static SecurityAbstractFactory instance() {
		if (null == uniqueInstance) {
			uniqueInstance = new SecurityAbstractFactory();
		}
		return uniqueInstance;
	}

	private SecurityAbstractFactory() {
		passwordEncryption = new BCryptPasswordEncryption();
	}

	public IPasswordEncryption createBCryptPasswordEncryption() {
		return passwordEncryption;
	}

}

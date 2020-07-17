package CSCI5308.GroupFormationTool.PasswordValidationTest;

import CSCI5308.GroupFormationTool.PasswordValidation.IPasswordValidatorPersistence;

public class PasswordAbstractFactoryTest {

	private static PasswordAbstractFactoryTest uniqueInstance = null;
	private IPasswordValidatorPersistence passwordValidatorPersistence;

	public static PasswordAbstractFactoryTest instance() {
		if (null == uniqueInstance) {
			uniqueInstance = new PasswordAbstractFactoryTest();
		}
		return uniqueInstance;
	}

	private PasswordAbstractFactoryTest() {
		passwordValidatorPersistence = new PasswordValidatorDBMock();
	}

	public IPasswordValidatorPersistence getPasswordValidatorPersistence() {
		return passwordValidatorPersistence;
	}

}

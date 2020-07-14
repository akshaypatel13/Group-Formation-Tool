package CSCI5308.GroupFormationTool.PasswordValidation;

import CSCI5308.GroupFormationTool.AccessControl.User;

public class PasswordValidationAbstractFactory {

    private static PasswordValidationAbstractFactory uniqueInstance = null;
    public IPasswordValidatorPersistence passwordValidatorPersistence;
    public IPasswordValidatorEnumerator passwordValidatorEnumerator;
    public PasswordValidator maximumLengthValidator;
    public PasswordValidator minimumLengthValidator;
    public PasswordValidator minimumLowercaseValidator;
    public PasswordValidator minimumSymbolValidator;
    public PasswordValidator minimumUppercaseValidator;
    public PasswordValidator passwordHistoryValidator;
    public PasswordValidator restrictedCharacterValidator;

    public PasswordValidationAbstractFactory(){
        passwordValidatorPersistence = new PasswordValidatorDB();
    }

    public PasswordValidationAbstractFactory(String constraint){
        maximumLengthValidator = new MaximumLengthValidator(constraint);
        minimumLengthValidator = new MinimumLengthValidator(constraint);
        minimumLowercaseValidator = new MinimumLowercaseValidator(constraint);
        minimumSymbolValidator = new MinimumSymbolValidator(constraint);
        minimumUppercaseValidator = new MinimumUppercaseValidator(constraint);
        restrictedCharacterValidator = new RestrictedCharacterValidator(constraint);

    }

    public PasswordValidationAbstractFactory(String constraint, User user){
        passwordHistoryValidator = new PasswordHistoryValidator(constraint,user);
    }

    public static PasswordValidationAbstractFactory instance() {
        if (null == uniqueInstance) {
            uniqueInstance = new PasswordValidationAbstractFactory();
        }
        return uniqueInstance;
    }

    public static PasswordValidationAbstractFactory instance(String constraint) {
        if (null == uniqueInstance) {
            uniqueInstance = new PasswordValidationAbstractFactory(constraint);
        }
        return uniqueInstance;
    }

    public static PasswordValidationAbstractFactory instance(String constraint, User user) {
        if (null == uniqueInstance) {
            uniqueInstance = new PasswordValidationAbstractFactory(constraint,user);
        }
        return uniqueInstance;
    }

    public IPasswordValidatorPersistence createPasswordValidatorDBInstance(){
        return passwordValidatorPersistence;
    }


    public PasswordValidator createMaximumLengthValidatorInstance(){
        return maximumLengthValidator;
    }

    public PasswordValidator createMinimumLengthValidatorInstance(){
        return minimumLengthValidator;
    }

    public PasswordValidator createMinimumLowercaseValidatorInstance(){
        return minimumLowercaseValidator;
    }

    public PasswordValidator createMinimumUppercaseValidatorInstance(){
        return minimumUppercaseValidator;
    }

    public PasswordValidator createMinimumSymbolValidatorInstance(){
        return minimumSymbolValidator;
    }

    public PasswordValidator createPasswordHistoryValidator(){
        return passwordHistoryValidator;
    }

    public PasswordValidator createRestrictedCharacterValidatorInstance(){
        return restrictedCharacterValidator;
    }

    public void setPasswordEnumeratorInstance(IPasswordValidatorEnumerator passwordValidatorEnumerator){
        this.passwordValidatorEnumerator = passwordValidatorEnumerator;
    }

    public IPasswordValidatorEnumerator getPasswordValidatorEnumerator(){
        return passwordValidatorEnumerator;
    }

    public IPasswordValidatorEnumerator createPasswordValidatorInstance(IPasswordValidatorPersistence validatorDB){
        return new PasswordValidatorEnumerator(validatorDB);
    }

}

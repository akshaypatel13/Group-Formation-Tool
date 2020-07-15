package CSCI5308.GroupFormationTool.PasswordValidation;

import CSCI5308.GroupFormationTool.AccessControl.IUser;

public class PasswordValidationAbstractFactory {

    private static PasswordValidationAbstractFactory uniqueInstance = null;
    private static IPasswordValidatorPersistence passwordValidatorPersistence;
    private IPasswordValidatorEnumerator passwordValidatorEnumerator;


    private PasswordValidationAbstractFactory(){
        passwordValidatorPersistence = new PasswordValidatorDB();
    }


    public static PasswordValidationAbstractFactory instance() {
        if (null == uniqueInstance) {
            uniqueInstance = new PasswordValidationAbstractFactory();
        }
        return uniqueInstance;
    }


    public IPasswordValidatorPersistence createPasswordValidatorDBInstance(){
        return passwordValidatorPersistence;
    }


    public PasswordValidator createMaximumLengthValidatorInstance(String constraint){
        return new MaximumLengthValidator(constraint);
    }

    public PasswordValidator createMinimumLengthValidatorInstance(String constraint){
        return new MinimumLengthValidator(constraint);
    }

    public PasswordValidator createMinimumLowercaseValidatorInstance(String constraint){
        return new MinimumLowercaseValidator(constraint);
    }

    public PasswordValidator createMinimumUppercaseValidatorInstance(String constraint){
        return new MinimumUppercaseValidator(constraint);
    }

    public PasswordValidator createMinimumSymbolValidatorInstance(String constraint){

        return new MinimumSymbolValidator(constraint);
    }

    public PasswordValidator createPasswordHistoryValidator(String constraint, IUser user){
        return new PasswordHistoryValidator(constraint,user);
    }

    public PasswordValidator createRestrictedCharacterValidatorInstance(String constraint){
        return new RestrictedCharacterValidator(constraint);
    }

    public void setPasswordEnumeratorInstance(IPasswordValidatorEnumerator passwordValidatorEnumerator){
        this.passwordValidatorEnumerator = passwordValidatorEnumerator;
    }

    public IPasswordValidatorEnumerator getPasswordValidatorEnumerator(){
        return passwordValidatorEnumerator;
    }

    public PasswordValidatorEnumerator createPasswordEnumerator(IPasswordValidatorPersistence validatorDB){
        return new PasswordValidatorEnumerator(validatorDB);
    }


}

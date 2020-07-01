package CSCI5308.GroupFormationTool.PasswordPolicy;

import CSCI5308.GroupFormationTool.AccessControl.User;
import CSCI5308.GroupFormationTool.Security.IPasswordEncryption;
import CSCI5308.GroupFormationTool.SystemConfig;

import java.util.List;

public class PasswordHistoryValidator implements IPasswordPolicyValidator{

    String value;
    User user;
    IPasswordManager passwordManager;

    public PasswordHistoryValidator(String value, User U)
    {
        this.passwordManager = SystemConfig.instance().getPasswordManager();
        this.value = value;
        this.user = U;
    }
    @Override
    public boolean isPasswordValid(String password)
    {

        List<String> previousPasswords = passwordManager.getPreviousPasswords(this.user, Integer.parseInt(value));
        IPasswordEncryption passwordEncryption = SystemConfig.instance().getPasswordEncryption();

        for(int i=0;i<previousPasswords.size();i++){
            if (passwordEncryption.matches(password, previousPasswords.get(i)))
            {
                return false;
            }
        }
        return true;
    }
}

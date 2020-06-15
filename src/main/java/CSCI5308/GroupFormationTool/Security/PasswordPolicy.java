package CSCI5308.GroupFormationTool.Security;

import CSCI5308.GroupFormationTool.AccessControl.User;

import java.util.List;

public class PasswordPolicy {
    private int limit;
    private IPasswordManager passwordManager;

    public PasswordPolicy(IPasswordManager passwordManager){
        limit = 3;
        this.passwordManager = passwordManager;
    }

    public boolean checkPreviousPassword(User U){

        List<String> previousPasswords = passwordManager.getPreviousPasswords(U, limit);
        for(int i=0;i<previousPasswords.size();i++){
            if (previousPasswords.get(i).equals(U.getPassword()))
                return true;
        }
        return false;
    }

}

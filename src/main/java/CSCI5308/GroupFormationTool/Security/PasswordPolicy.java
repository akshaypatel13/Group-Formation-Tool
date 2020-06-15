package CSCI5308.GroupFormationTool.Security;

import CSCI5308.GroupFormationTool.AccessControl.User;
import CSCI5308.GroupFormationTool.Courses.Course;
import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

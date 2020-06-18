package CSCI5308.GroupFormationTool.SecurityTest;

import CSCI5308.GroupFormationTool.AccessControl.User;
import CSCI5308.GroupFormationTool.Security.IPasswordManager;

import java.util.ArrayList;
import java.util.List;

public class PasswordManagerMock implements IPasswordManager {

    @Override
    public List<String> getPreviousPasswords(User u, int limit) {
        List<String> previousPassword = new ArrayList<>();
        previousPassword.add("one");
        previousPassword.add("two");
        previousPassword.add("Pass@123");
        return previousPassword;
    }
}

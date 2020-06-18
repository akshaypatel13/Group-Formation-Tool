package CSCI5308.GroupFormationTool.Security;

import CSCI5308.GroupFormationTool.AccessControl.User;

import java.util.List;

public interface IPasswordManager {
    public List<String> getPreviousPasswords(User u, int limit);
}

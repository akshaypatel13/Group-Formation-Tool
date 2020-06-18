package CSCI5308.GroupFormationTool.ResetPasswordTest;

import CSCI5308.GroupFormationTool.AccessControl.User;
import CSCI5308.GroupFormationTool.Resetpassword.IUserResetPasswordDAO;
import CSCI5308.GroupFormationTool.Resetpassword.IUserResetPasswordDB;
import CSCI5308.GroupFormationTool.Resetpassword.UserResetPasswordDAO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class UserResetPasswordDAOTest {

    IUserResetPasswordDAO userResetPasswordDAO;
    IUserResetPasswordDB userResetPasswordDB;

    @Test
    public void saveUserResetTokenTest(){
        userResetPasswordDAO = new UserResetPasswordDAO();
        userResetPasswordDB = new ResetPasswordDBMock();
        User user = new User();
        userResetPasswordDAO.saveUserResetToken(userResetPasswordDB, user);
        Assert.isTrue(user.getResetToken().equals("12345"));
    }

    @Test
    public void findUserByResetToken(){
        userResetPasswordDAO = new UserResetPasswordDAO();
        userResetPasswordDB = new ResetPasswordDBMock();
        User user = userResetPasswordDAO.findUserByResetToken(userResetPasswordDB, "12345");
        Assert.isTrue(user.getResetToken().equals("12345"));
    }

    @Test
    public void saveUserPassword(){
        userResetPasswordDAO = new UserResetPasswordDAO();
        userResetPasswordDB = new ResetPasswordDBMock();
        User user = new User();
        userResetPasswordDAO.saveUserPassword(userResetPasswordDB, user);
        Assert.isTrue(user.getPassword().equals("password"));
    }
}

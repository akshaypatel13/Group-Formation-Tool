package CSCI5308.GroupFormationTool.QuestionManageTest;

import CSCI5308.GroupFormationTool.QuestionManage.Options;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class OptionsTest {

    @Test
    public void setDescription(){
        Options options=new Options();
        options.setDescription("Hello");
        Assert.isTrue(options.getDescription().equals("Hello"));
    }

    @Test
    public void setStoredAs(){
        Options options=new Options();
        options.setStoredAs(1);
        Assert.isTrue(options.getStoredAs()==1);
    }

    @Test
    public void getStoredAs(){
        Options options=new Options();
        options.setStoredAs(1);
        Assert.isTrue(options.getStoredAs()==1);
    }

    @Test
    public void getDescription(){
        Options options=new Options();
        options.setDescription("Hello");
        Assert.isTrue(options.getDescription().equals("Hello"));
    }

}

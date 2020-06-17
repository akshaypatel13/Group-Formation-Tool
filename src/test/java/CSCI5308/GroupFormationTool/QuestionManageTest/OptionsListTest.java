package CSCI5308.GroupFormationTool.QuestionManageTest;

import CSCI5308.GroupFormationTool.QuestionManage.IQuestionPersistence;
import CSCI5308.GroupFormationTool.QuestionManage.Options;
import CSCI5308.GroupFormationTool.QuestionManage.OptionsList;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class OptionsListTest {

    @Test
    public void insertOptions(){
        IQuestionPersistence questionDB = new QuestionDBMock();
        Options options=new Options();
        questionDB.insertOptions(options);
        Assert.isTrue(options.getDescription().equals("Option1"));
        Assert.isTrue(options.getStoredas()==1);
    }

    @Test
    public void insertOptionsFalse(){
        IQuestionPersistence questionDB = new QuestionDBMock();
        Options options=new Options();
        questionDB.insertOptions(options);
        assertFalse(options.getDescription().equals("Option2"));
        assertFalse(options.getStoredas()==2);
    }

    @Test
    public void getOptionsTest(){
        List<Options> options=new ArrayList<Options>();

    }

    @Test
    public void setOptions(){
        OptionsList options=new OptionsList();
        List<Options> option=new ArrayList<Options>();
        options.setOptions(option);
        Assert.isTrue(options.getOptions()==option);
    }

    @Test
    public void getOptions(){
        OptionsList options=new OptionsList();
        List<Options> option=new ArrayList<Options>();
        options.setOptions(option);
        Assert.isTrue(options.getOptions()==option);
    }

}

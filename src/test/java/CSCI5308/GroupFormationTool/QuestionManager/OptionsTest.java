package CSCI5308.GroupFormationTool.QuestionManager;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

@SuppressWarnings("deprecation")
class OptionsTest 
{
	@Test
	public void ConstructorTests()
	{
		IOptions options = QuestionManagerAbstractFactory.instance().createOptionsInstance();
		Assert.isTrue(options.getOptionList().size() == 0);
	}

	@Test
	public void getOptionList()
	{
		IOptions options = QuestionManagerAbstractFactory.instance().createOptionsInstance();
		List<OptionValue> list = new ArrayList<>();
		list.add(QuestionManagerAbstractFactory.instance().createOptionValueParamInstance("test","test"));
		options.setOptionList(list);
		Assert.isTrue(options.getOptionList() == list);

	}

	@Test
	public void setOptionList()
	{
		IOptions options = QuestionManagerAbstractFactory.instance().createOptionsInstance();
		List<OptionValue> list = new ArrayList<>();
		list.add(QuestionManagerAbstractFactory.instance().createOptionValueParamInstance("test","test"));
		options.setOptionList(list);
		Assert.isTrue(options.getOptionList() == list);
	}

	@Test
	public void addOption()
	{
		IOptions options = QuestionManagerAbstractFactory.instance().createOptionsInstance();
		options.addOption();
		Assert.isTrue(options.getOptionList().size()>0);
	}

	@Test
	public void saveOptions()
	{
		OptionValue option = QuestionManagerAbstractFactory.instance().createOptionValueParamInstance("Test Text","1");
		IQuestionPersistence questionDB = QuestionManagerAbstractFactoryTest.instance().getQuestionPersistence();
		boolean status = questionDB.createQuestionOption(option, 1, 1);
		Assert.isTrue(status == true);
		status = questionDB.createQuestionOption(option, 1, -1);
		Assert.isTrue(status == false);
		option = QuestionManagerAbstractFactory.instance().createOptionValueParamInstance("","");
		status = questionDB.createQuestionOption(option, 1, 1);
		Assert.isTrue(status == false);
	}

}

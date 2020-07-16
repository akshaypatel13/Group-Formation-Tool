package CSCI5308.GroupFormationTool.QuestionManager;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("deprecation")
class OptionValueTest 
{
	@Test
	public void ConstructorTests()
	{
		IOptionValue value = QuestionManagerAbstractFactory.instance().createOptionValueInstance();
		Assert.isTrue(isStringEmpty(value.getText()));
		Assert.isTrue(isStringEmpty(value.getStoredAs()));
	}

	@Test
	public void getText()
	{
		IOptionValue value = QuestionManagerAbstractFactory.instance().createOptionValueInstance();
		value.setText("Test Text");
		Assert.isTrue(value.getText().equals("Test Text"));
	}

	@Test
	public void setText()
	{
		IOptionValue value = QuestionManagerAbstractFactory.instance().createOptionValueInstance();
		value.setText("Test Text");
		Assert.isTrue(value.getText().equals("Test Text"));
	}

	@Test
	public void getStoredAs()
	{
		IOptionValue value = QuestionManagerAbstractFactory.instance().createOptionValueInstance();
		value.setStoredAs("Test");
		Assert.isTrue(value.getStoredAs().equals("Test"));
	}

	@Test
	public void setStoredAs()
	{
		IOptionValue value = QuestionManagerAbstractFactory.instance().createOptionValueInstance();
		value.setStoredAs("Test");
		Assert.isTrue(value.getStoredAs().equals("Test"));
	}

	public boolean isStringEmpty(String s)
	{
		return s.replaceAll(" ","").length() == 0;
	}

}

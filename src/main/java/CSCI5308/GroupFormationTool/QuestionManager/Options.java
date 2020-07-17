package CSCI5308.GroupFormationTool.QuestionManager;

import java.util.ArrayList;
import java.util.List;

public class Options implements IOptions {
	public List<OptionValue> optionList;

	public Options() {
		setDefault();
	}

	public void setDefault() {
		optionList = new ArrayList<>();
	}

	public List<OptionValue> getOptionList() {
		return optionList;
	}

	public void setOptionList(List<OptionValue> optionList) {
		this.optionList = optionList;
	}

	public void addOption() {
		String index = String.valueOf(optionList.size() + 1);
		optionList.add(QuestionManagerAbstractFactory.instance().createOptionValueParamInstance(index, index));
	}

	public void saveOptions(IQuestionPersistence questionDB, long questionID) {
		int order = 1;
		if (questionID != -1) {
			for (OptionValue option : optionList) {
				String text = option.getText();
				String storedAs = option.getStoredAs();
				if (isStringEmpty(text) || isStringEmpty(storedAs)) {
					continue;
				}
				questionDB.createQuestionOption(option, order++, questionID);
			}
		}

	}

	public boolean isStringEmpty(String s) {
		return s.replaceAll(" ", "").length() == 0;
	}

}

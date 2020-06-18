package CSCI5308.GroupFormationTool.QuestionManage;

import java.util.ArrayList;
import java.util.List;

public class OptionsList {

	public List<Options> options = new ArrayList<Options>();

	public List<Options> getOptions() {
		return options;
	}

	public void setOptions(List<Options> options) {
		this.options = options;
	}

	/*
	 * public void addOptions(Options options){ this.options.add(options); }
	 */

	public void add(int number) {
		for (int i = 1; i <= 5; i++) {
			this.options.add(new Options(i));
		}
	}

	public boolean insertOptions(IQuestionPersistence questionDB, OptionsList options) {
		for (int i = 0; i < 5; i++) {
			Options option = new Options();
			option.setDescription(options.getOptions().get(i).getDescription());
			option.setStoredas(options.getOptions().get(i).getStoredas());
			questionDB.insertOptions(option);
		}
		return true;
	}

}

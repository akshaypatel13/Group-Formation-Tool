package CSCI5308.GroupFormationTool.QuestionManager;

import CSCI5308.GroupFormationTool.PasswordValidation.PasswordValidationAbstractFactory;

import java.util.ArrayList;
import java.util.List;

public class QuestionManagerAbstractFactory {

	private static QuestionManagerAbstractFactory uniqueInstance = null;
	private IQuestionPersistence questionDB;

	public static QuestionManagerAbstractFactory instance() {
		if (null == uniqueInstance) {
			uniqueInstance = new QuestionManagerAbstractFactory();
		}
		return uniqueInstance;
	}

	private QuestionManagerAbstractFactory() {
		questionDB = new QuestionDB();
	}

	public IQuestion createQuestionInstance() {
		return new Question();
	}

	public IOptionValue createOptionValueInstance() {
		return new OptionValue();
	}

	public IOptions createOptionsInstance() {
		return new Options();
	}

	public IQuestionPersistence createQuestionDBInstance() {
		return questionDB;
	}

	public OptionValue createOptionValueParamInstance(String text, String storedas) {
		return new OptionValue(text, storedas);
	}

}

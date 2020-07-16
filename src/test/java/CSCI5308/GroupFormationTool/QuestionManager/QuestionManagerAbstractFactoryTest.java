package CSCI5308.GroupFormationTool.QuestionManager;

public class QuestionManagerAbstractFactoryTest {

	private static QuestionManagerAbstractFactoryTest uniqueInstance = null;
	private IQuestionPersistence questionPersistence;

	public static QuestionManagerAbstractFactoryTest instance() {
		if (null == uniqueInstance) {
			uniqueInstance = new QuestionManagerAbstractFactoryTest();
		}
		return uniqueInstance;
	}

	private QuestionManagerAbstractFactoryTest() {
		questionPersistence = new QuestionDBMock();
	}

	public IQuestionPersistence getQuestionPersistence() {
		return questionPersistence;
	}

}

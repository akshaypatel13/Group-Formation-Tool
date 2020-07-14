package CSCI5308.GroupFormationTool.QuestionManager;

public interface IQuestionManagerAbstractFactory {

    public IQuestion createQuestionInstance();

    public IOptionValue createOptionValueInstance();

    public IOptions createOptionsInstance();

    public IQuestionPersistence createQuestionDBInstance();

    public OptionValue createOptionValueParamInstance(String text, String storedas);


}

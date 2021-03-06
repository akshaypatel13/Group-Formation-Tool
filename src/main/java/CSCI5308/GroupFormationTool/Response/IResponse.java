package CSCI5308.GroupFormationTool.Response;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import CSCI5308.GroupFormationTool.QuestionManager.IQuestion;

public interface IResponse {
	public void setDefaults();

	public long getId();

	public void setId(long id);

	public String getResponse();

	public void setResponse(String response);

	public List<IQuestion> sortQuestionByDateCreated(List<IQuestion> questionList,
			List<IQuestion> loadQuestionsOptions);

	public HashMap<String, String> saveResponseAnswer(HttpServletRequest request, List<IQuestion> questionList,
			List<IQuestion> loadQuestionsOptions);

	public List<IQuestion> loadQuestionOptions(List<IQuestion> questions, IResponsePersistence responsePersistence);

	public boolean saveResponse(HashMap<String, String> answer, String bannerId);
}

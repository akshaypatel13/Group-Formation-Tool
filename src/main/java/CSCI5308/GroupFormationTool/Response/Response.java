package CSCI5308.GroupFormationTool.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import CSCI5308.GroupFormationTool.QuestionManager.IQuestion;
import CSCI5308.GroupFormationTool.QuestionManager.QuestionType;

public class Response implements IResponse {

	private long id;
	private String response;

	public Response() {
		setDefaults();
	}

	public void setDefaults() {
		id = -1;
		response = "";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public List<IQuestion> sortQuestionByDateCreated(List<IQuestion> quesionsWithoutOptions,
			List<IQuestion> quesionsWithOptions) {
		List<IQuestion> questions = new ArrayList<>();

		for (IQuestion question : quesionsWithoutOptions) {
			questions.add(question);
		}
		for (IQuestion question : quesionsWithOptions) {
			questions.add(question);
		}

		for (int i = 0; i < questions.size(); i++) {
			for (int j = i + 1; j < questions.size(); j++) {
				if (questions.get(i).getTimestamp().after(questions.get(j).getTimestamp())) {
					IQuestion question = questions.get(i);
					questions.set(i, questions.get(j));
					questions.set(j, question);
				}
			}
		}

		return questions;
	}

	public HashMap<String, String> saveResponseAnswer(HttpServletRequest request, List<IQuestion> questionList,
			List<IQuestion> loadQuestionsOptions) {

		HashMap<String, String> answer = new HashMap<String, String>();

		for (IQuestion question : questionList) {
			String id = Long.toString(question.getId());
			answer.put(id, request.getParameter(id));
		}

		for (IQuestion question : loadQuestionsOptions) {
			String id = Long.toString(question.getId());
			if (question.getType().toString() == QuestionType.MCQMULTIPLE.toString()) {

				String result = "";
				for (String response : question.getOptions()) {

					if (null != request.getParameter(id + ':' + response)) {
						result += ":" + response;
					}
				}
				answer.put(id, result);
			} else {
				answer.put(id, request.getParameter(id));
			}
		}

		return answer;
	}
}

package CSCI5308.GroupFormationTool.Response;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import CSCI5308.GroupFormationTool.QuestionManager.IQuestion;
import CSCI5308.GroupFormationTool.QuestionManager.IQuestionPersistence;
import CSCI5308.GroupFormationTool.QuestionManager.OptionValue;
import CSCI5308.GroupFormationTool.QuestionManager.Question;
import CSCI5308.GroupFormationTool.QuestionManager.QuestionDBMock;

@SuppressWarnings("deprecation")
public class ReponseTest {
		
	@Test
	public void getId() 
	{
		Response response = new Response();
		response.setId(7);
		Assert.isTrue(response.getId() == 7);
	}
	
	@Test
	public void setId() 
	{
		Response response = new Response();
		response.setId(7);
		Assert.isTrue(response.getId() == 7);
	}
	
	@Test
	public void getResponse() 
	{
		Response response = new Response();
		response.setResponse("Here is the answer");
		Assert.isTrue(response.getResponse().equals("Here is the answer"));
	}
	
	@Test
	public void setResponse() 
	{
		Response response = new Response();
		response.setResponse("Here is the answer");
		Assert.isTrue(response.getResponse().equals("Here is the answer"));
	}
	
	@Test
	public void sortQuestionByDateCreated() {
		
		List<IQuestion> questions1 = new ArrayList<>();
		List<IQuestion> questions2 = new ArrayList<>();
		
		Question question1 = new Question();
		question1.setTimestamp(Timestamp.valueOf("2020-06-16 00:00:00"));

		Question question2 = new Question();
		question2.setTimestamp(Timestamp.valueOf("2020-06-26 00:00:00"));
		
		questions1.add(question1);
		questions2.add(question2);
		
		Response response = new Response();
		List<IQuestion> result = response.sortQuestionByDateCreated(questions1, questions2);
		Assert.isTrue(result.indexOf(question1) == 0);
	}
	
	@Test
	public void saveResponseAnswer() {
		
		HashMap<String, String> answer = new HashMap<>();
		answer.put("Question", "Response");

		IResponsePersistence responseDB = new ResponseDBMock();
		boolean status = responseDB.saveResponse("1", "B-000000","selected");
		Assert.isTrue(status == true);

	}
}

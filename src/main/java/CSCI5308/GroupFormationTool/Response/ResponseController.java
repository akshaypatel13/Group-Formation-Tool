package CSCI5308.GroupFormationTool.Response;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import CSCI5308.GroupFormationTool.Survey.SurveyAbstractFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import CSCI5308.GroupFormationTool.SystemConfig;
import CSCI5308.GroupFormationTool.QuestionManager.Question;
import CSCI5308.GroupFormationTool.QuestionManager.QuestionType;
import CSCI5308.GroupFormationTool.Survey.ISurveyAdminPersistence;

@Controller
public class ResponseController {
/*
	private static final String ID = "id";
	private static final String BannerID = "bannerID";
	private IResponsePersistence responseDB;
    private ISurveyAdminPersistence surveyAdminDB;
	
	public ResponseController() 
	{
		responseDB = SystemConfig.instance().getResponseDB();
        surveyAdminDB = SurveyAbstractFactory.instance().createSurveyAdminDBInstance();
	}
	
	@RequestMapping("/response/takingsurvey")
	public String loadQuestions(Model model,  @RequestParam(name = ID) long courseId) 
	{
		List<Question> questionList = responseDB.loadQuestionsWithoutOptions(courseId);
		List<Question> questionListWithOptions = responseDB.loadQuestionsWithOptions(courseId);
		List<Question> loadQuestionsOptions = responseDB.loadQuestionsOptions(questionListWithOptions);
		List<Question> questions = surveyAdminDB.sortQuestionByDateCreated(questionList, loadQuestionsOptions);
		
		model.addAttribute("courseId", courseId);
		model.addAttribute("questionList", questions);
		
		return "/response/response";
	}
	
	@RequestMapping("/response/survey")
	public String submitSurvey(Model model, @RequestParam(name = ID) long courseId,
			@RequestParam(name = BannerID) String bannerId, HttpServletRequest request) 
	{
		
		HashMap<String, String> answer = new HashMap<String, String>();
		
		List<Question> questionList = responseDB.loadQuestionsWithoutOptions(courseId);
		List<Question> questionListWithOptions = responseDB.loadQuestionsWithOptions(courseId);
		List<Question> loadQuestionsOptions = responseDB.loadQuestionsOptions(questionListWithOptions);
		
		for(Question question : questionList) {
			String id = Long.toString(question.getId());
			answer.put(id, request.getParameter(id));
		}
		
		for(Question question : loadQuestionsOptions) {
			String id = Long.toString(question.getId());
			if(question.getType().toString() == QuestionType.MCQMULTIPLE.toString()) {
				
				String result = "";
				for(String response : question.getOptions()) {
					
					if(null != request.getParameter(id+':'+response)) {
						result += ":" + response;
					}
				}
				answer.put(id, result);
			}else {
				answer.put(id, request.getParameter(id));
			}
		}
		
		responseDB.saveResponse(answer, bannerId);
		
		return "redirect:/course/course?id="+courseId;
	}*/
}

package CSCI5308.GroupFormationTool.Response;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import CSCI5308.GroupFormationTool.QuestionManager.IQuestion;

@Controller
public class ResponseController {

	private static final String ID = "id";
	private static final String BannerID = "bannerID";
	private static final Logger LOG = LogManager.getLogger(ResponseController.class);
	private IResponsePersistence responseDB;

	public ResponseController() {
		responseDB = ResponseAbstractFactory.instance().createResponseDBInstance();
	}

	@RequestMapping("/response/takingsurvey")
	public String loadQuestions(Model model, @RequestParam(name = ID) long courseId) {
		IResponse response = ResponseAbstractFactory.instance().createResponseInstance();
		List<IQuestion> questionList = responseDB.loadQuestionsWithoutOptions(courseId);
		List<IQuestion> questionListWithOptions = responseDB.loadQuestionsWithOptions(courseId);
		List<IQuestion> loadQuestionsOptions = response.loadQuestionOptions(questionListWithOptions, responseDB);

		List<IQuestion> questions = response.sortQuestionByDateCreated(questionList, loadQuestionsOptions);
		LOG.info("Loading Questions for CourseID = " + courseId + ", Questions =" + questions);
		model.addAttribute("courseId", courseId);
		model.addAttribute("questionList", questions);

		return "response/response";
	}

	@RequestMapping("/response/survey")
	public String submitSurvey(Model model, @RequestParam(name = ID) long courseId,
			@RequestParam(name = BannerID) String bannerId, HttpServletRequest request) {
		IResponse response = ResponseAbstractFactory.instance().createResponseInstance();
		List<IQuestion> questionList = responseDB.loadQuestionsWithoutOptions(courseId);

		List<IQuestion> questionListWithOptions = responseDB.loadQuestionsWithOptions(courseId);
		List<IQuestion> loadQuestionsOptions = response.loadQuestionOptions(questionListWithOptions, responseDB);
		LOG.info("Loaded Questions Without Options for CourseID = " + courseId + ", Questions =" + questionList);

		LOG.info("Loaded Questions With Options for CourseID = " + courseId + ", Questions =" + loadQuestionsOptions);

		HashMap<String, String> answer = response.saveResponseAnswer(request, questionList, loadQuestionsOptions);

		boolean status = response.saveResponse(answer, bannerId);
		model.addAttribute("status", status);
		if (status) {
			return "redirect:/course/course?id=" + courseId;
		} else {
			return "responseExceptionHandling";
		}
	}
}

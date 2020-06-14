package CSCI5308.GroupFormationTool.QuestionManage;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import CSCI5308.GroupFormationTool.SystemConfig;
import CSCI5308.GroupFormationTool.AccessControl.CurrentUser;

/**
 * 
 * @author nieruize
 *
 */
@Controller
public class QuestionController {
	
	private static final String ID = "id";
	
	@GetMapping("/question/question")
	public String question(Model model) {
		IQuestionPersistence questionDB = SystemConfig.instance().getQuestionDB();
		
		List<Question> allQuestions = questionDB.loadAllQuestions(CurrentUser.instance().getCurrentAuthenticatedUser());
		model.addAttribute("questions", allQuestions);

		return "question/question";
	}
	
	@GetMapping("/question/{sort}")
	public String sortQuestion(@PathVariable("sort") String sort, Model model) {
		IQuestionPersistence questionDB = SystemConfig.instance().getQuestionDB();
		
		List<Question> sortQuestions = questionDB.sortAllQuestions(sort, CurrentUser.instance().getCurrentAuthenticatedUser());
		model.addAttribute("questions", sortQuestions);
		
		return "question/question";
	}
	
	@GetMapping("question/warning")
	public String deleteWarning(@RequestParam(name = ID) long questionID, Model model) {
		model.addAttribute("questionID", questionID);
		return "question/warning";
	}
	
	@GetMapping("/question/delete")
	public String deleteQuestion(@RequestParam(name = ID) long questionID) {
		IQuestionPersistence questionDB = SystemConfig.instance().getQuestionDB();
		
		Question q = new Question();
		q.setId(questionID);
		q.delete(questionDB);
		return "redirect:/question/question";
	}
}

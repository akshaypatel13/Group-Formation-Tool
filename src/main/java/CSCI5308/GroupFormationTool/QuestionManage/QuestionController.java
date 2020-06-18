package CSCI5308.GroupFormationTool.QuestionManage;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import CSCI5308.GroupFormationTool.SystemConfig;
import CSCI5308.GroupFormationTool.AccessControl.CurrentUser;

/**
 * @author nieruize
 */
@Controller
public class QuestionController {

	private static final String ID = "id";
	private static final String TITLE = "title";
	private static final String DESCRIPTION = "description";
	private static final String TYPE = "type";
	public static final List<String> questionTypes = Collections.unmodifiableList(
			Arrays.asList("Numeric", "Multiple Choice, Choose One", "Multiple choice, Choose Multiple", "Free text"));

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

		List<Question> sortQuestions = questionDB.sortAllQuestions(sort,
				CurrentUser.instance().getCurrentAuthenticatedUser());
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

	@GetMapping("/question/create")
	public String createQuestion(Model model) {
		model.addAttribute("questionTypes", questionTypes);
		return "question/questioninsert";
	}

	@RequestMapping(value = "/question/insert", method = RequestMethod.POST)
	public String insertQuestion(Model model, @RequestParam(name = TITLE) String title,
			@RequestParam(name = DESCRIPTION) String description, @RequestParam(name = TYPE) String type) {

		IQuestionPersistence questionDB = SystemConfig.instance().getQuestionDB();
		Question question = new Question();
		question.setTitle(title);
		question.setDescription(description);
		question.setType(type);
		System.out.print(type);
		question.insertQuestion(questionDB, CurrentUser.instance().getCurrentAuthenticatedUser());
		if (type.equals("Numeric") || type.equals("Free text")) {
			return "redirect:/question/questioninsert";
		} else {
			OptionsList opts = new OptionsList();
			opts.add(5);
			model.addAttribute("opts", opts);
			return "question/question_options";
		}

	}

	@RequestMapping(value = "/question/insertOptions")
	public String options(@ModelAttribute OptionsList options, final BindingResult bindingresult, Model model) {
		IQuestionPersistence questionDB = SystemConfig.instance().getQuestionDB();
		OptionsList optionsList = new OptionsList();
		optionsList.insertOptions(questionDB, options);
		List<Question> allQuestions = questionDB.loadAllQuestions(CurrentUser.instance().getCurrentAuthenticatedUser());
		model.addAttribute("questions", allQuestions);
		return "question/question";
	}

}

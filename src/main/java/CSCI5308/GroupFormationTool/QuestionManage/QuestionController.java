package CSCI5308.GroupFormationTool.QuestionManage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import CSCI5308.GroupFormationTool.SystemConfig;
import CSCI5308.GroupFormationTool.AccessControl.CurrentUser;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author nieruize
 */
@Controller
public class QuestionController {

	private static final String ID = "id";
	private static final String TITLE = "title";
	private static final String DESCRIPTION = "description";
	private static final String TYPE = "type";

	@GetMapping("/question/question")
	public String question(Model model)
	{
		IQuestionPersistence questionDB = SystemConfig.instance().getQuestionDB();
		List<Question> allQuestions = questionDB.loadAllQuestions(CurrentUser.instance().getCurrentAuthenticatedUser());
		model.addAttribute("questions", allQuestions);
		return "question/question";
	}

	@GetMapping("/question/{sort}")
	public String sortQuestion(@PathVariable("sort") String sort, Model model)
	{
		IQuestionPersistence questionDB = SystemConfig.instance().getQuestionDB();
		List<Question> sortQuestions = questionDB.sortAllQuestions(sort,
				CurrentUser.instance().getCurrentAuthenticatedUser());
		model.addAttribute("questions", sortQuestions);
		return "question/question";
	}

	@GetMapping("question/warning")
	public String deleteWarning(@RequestParam(name = ID) long questionID, Model model)
	{
		model.addAttribute("questionID", questionID);
		return "question/warning";
	}

	@GetMapping("/question/delete")
	public String deleteQuestion(@RequestParam(name = ID) long questionID)
	{
		IQuestionPersistence questionDB = SystemConfig.instance().getQuestionDB();
		Question q = new Question();
		q.setId(questionID);
		q.delete(questionDB);
		return "redirect:/question/question";
	}

	@GetMapping("/question/create")
	public String createQuestion(Model model)
	{
		List<QuestionType> questionTypes = new ArrayList<QuestionType>();
		Question question=new Question();
		questionTypes = Arrays.asList(QuestionType.values());
		model.addAttribute("question",question);
		model.addAttribute("questionTypes", questionTypes);
		return "question/questioninsert";
	}

	@RequestMapping(value = "/question/insert", method = RequestMethod.POST)
	public ModelAndView insertQuestion(Model model, @ModelAttribute Question question)
	{
		IQuestionPersistence questionDB = SystemConfig.instance().getQuestionDB();
		ModelAndView modelAndView = new ModelAndView();
		OptionsList opts = new OptionsList();
		question.insertQuestion(questionDB, CurrentUser.instance().getCurrentAuthenticatedUser());
		if (question.getType().equals(QuestionType.NUMERIC.toString()) || question.getType().equals(QuestionType.TEXT.toString())) {
			modelAndView.setViewName("redirect:/question/questioninsert");
		} else {
			opts.add();
			model.addAttribute("opts", opts);
			modelAndView.setViewName("question/question_options");
		}
		return modelAndView;
	}

	@RequestMapping(value = "/question/insertOptions")
	public String options(@ModelAttribute OptionsList options, final BindingResult bindingresult, Model model)
	{
		IQuestionPersistence questionDB = SystemConfig.instance().getQuestionDB();
		OptionsList optionsList = new OptionsList();
		optionsList.insertOptions(questionDB, options);
		List<Question> allQuestions = questionDB.loadAllQuestions(CurrentUser.instance().getCurrentAuthenticatedUser());
		model.addAttribute("questions", allQuestions);
		return "question/question";
	}

}

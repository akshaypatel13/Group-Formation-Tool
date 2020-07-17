package CSCI5308.GroupFormationTool.QuestionManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Controller
public class QuestionAdminController {
	
	private static final Logger LOG = LogManager.getLogger(QuestionAdminController.class);
	private static final String ID = "id";
	private static final String BannerID = "bannerID";
	private IQuestionPersistence questionDB;
	private IQuestion question;
	private IOptions options;

	public QuestionAdminController() {
		questionDB = QuestionManagerAbstractFactory.instance().createQuestionDBInstance();
	}

	@RequestMapping("/question/delete")
	public ModelAndView deleteQuestion(Model model, @RequestParam(name = ID) long questionId,
			@RequestParam(name = BannerID) String bannerId) {
		questionDB.deleteQuestionByQuestionId(questionId);
		LOG.info("Question Deleted :" + questionId);
		ModelAndView mav = new ModelAndView("redirect:/question/questionmanager/title?bannerID=" + bannerId);
		return mav;
	}

	@RequestMapping("question/add")
	public String addQuestion(Model model) {
		question = QuestionManagerAbstractFactory.instance().createQuestionInstance();
		List<QuestionType> questionType = new ArrayList<QuestionType>();
		questionType = Arrays.asList(QuestionType.values());
		model.addAttribute("question", question);
		model.addAttribute("questionTypes", questionType);
		return "question/addquestion";
	}

	@RequestMapping("/question/reviewQuestion")
	public ModelAndView addOptions(Model model, @RequestParam(name = BannerID) String bannerId,
			@ModelAttribute Question question) {
		options = QuestionManagerAbstractFactory.instance().createOptionsInstance();
		options.addOption();
		ModelAndView mav = new ModelAndView();
		LOG.info("Question review :" + question.getText());
		mav.addObject("question", question);
		mav.addObject("options", options);
		mav.setViewName("question/reviewquestion");
		return mav;
	}

	@RequestMapping("/question/submit")
	public ModelAndView saveQuestion(Model model, @ModelAttribute Question question, @ModelAttribute Options options,
			@RequestParam(name = BannerID) String bannerId) {
		long questionID = question.createQuestion(questionDB, bannerId);
		options.saveOptions(questionDB, questionID);
		LOG.info("Question added :" + question.getId());
		ModelAndView mav = new ModelAndView("redirect:/question/questionmanager/title?bannerID=" + bannerId);
		return mav;
	}

	@RequestMapping(value = "/question/submit", params = { "addOptionRow" })
	public ModelAndView addOptionRow(@ModelAttribute Question question, @ModelAttribute Options options,
			final BindingResult bindingResult) {
		options.addOption();
		LOG.info("Options added :" + options.getOptionList());
		ModelAndView mav = new ModelAndView();
		mav.addObject("question", question);
		mav.addObject("options", options);
		mav.setViewName("question/reviewquestion");
		return mav;
	}

}

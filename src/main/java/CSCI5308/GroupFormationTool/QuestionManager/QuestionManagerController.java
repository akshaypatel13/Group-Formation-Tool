package CSCI5308.GroupFormationTool.QuestionManager;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Controller
public class QuestionManagerController {

	private static final Logger LOG = LogManager.getLogger(QuestionManagerController.class);
	private static final String BannerID = "bannerID";
	private IQuestionPersistence questionDB;
	private List<IQuestion> questionList;

	public QuestionManagerController() {
		questionDB = QuestionManagerAbstractFactory.instance().createQuestionDBInstance();
	}

	@RequestMapping("/question/questionmanager/title")
	public String questionsByTitle(Model model, @RequestParam(name = BannerID) String bannerID) {
		questionList = questionDB.loadQuestionsSortedByTitle(bannerID);
		LOG.info("Question List Length :" + questionList.size());
		model.addAttribute("questionList", questionList);
		return "question/questions";
	}

	@RequestMapping("/question/questionmanager/date")
	public String questionsByDate(Model model, @RequestParam(name = BannerID) String bannerID) {
		questionList = questionDB.loadSortedQuestionsSortedByDate(bannerID);
		LOG.info("Question List Length :" + questionList.size());
		model.addAttribute("questionList", questionList);
		return "question/questions";
	}

}

package CSCI5308.GroupFormationTool.Survey;

import CSCI5308.GroupFormationTool.AccessControl.CurrentUser;
import CSCI5308.GroupFormationTool.QuestionManager.IQuestionPersistence;
import CSCI5308.GroupFormationTool.SystemConfig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SurveyAdminController
{

    private static final String courseID = "courseID";
    private static final String questionID = "questionID";
    private IQuestionPersistence questionDB;
    private ISurveyAdminPersistence surveyAdminDB;
    private ISurveyManagePersistence surveyManageDB;

    public SurveyAdminController()
    {
        questionDB = SystemConfig.instance().getQuestionDB();
        surveyAdminDB = SystemConfig.instance().getSurveyAdminDB();
        surveyManageDB = SystemConfig.instance().getSurveyManageDB();
    }

    @GetMapping("/survey/survey")
    public String survey(Model model, @RequestParam("courseID") long courseID)
    {
        surveyAdminDB.createSurvey(courseID);
        boolean check = surveyManageDB.surveyPublishedOrNot(courseID);
        System.out.print("Survey:"+check);
        model.addAttribute("surveyCheck", check);
        model.addAttribute("courseID",courseID);
        model.addAttribute("surveyQuestions",surveyManageDB.findSurveyQuestions(courseID));
        model.addAttribute("questionsNotInSurvey",surveyManageDB.findQuestionsNotInSurvey(CurrentUser.instance().getCurrentAuthenticatedUser().getID()));
        return "survey/surveyquestions";
    }

    @PostMapping("/survey/insertquestion")
    public String insertQuestionSurvey(Model model,@RequestParam("questionID") long questionID, @RequestParam("courseID") long courseID)
    {
        long surveyID = surveyManageDB.findSurveyByCourseID(courseID);
        surveyAdminDB.insertSurveyQuestion(surveyID,questionID);
        return "redirect:/survey/survey?courseID="+courseID;
    }

    @PostMapping("/surveyQuestion/delete")
    public String deleteSurveyQuestion(Model model,@RequestParam("questionID") long questionId, @RequestParam("courseID") long courseId)
    {
        surveyAdminDB.deleteSurveyQuestion(questionId);
        return "redirect:/survey/survey?courseID="+courseId;
    }

    @GetMapping("/survey/publish")
    public String publishSurvey(Model model, @RequestParam("courseID") long courseId)
    {
        surveyAdminDB.publishSurvey(courseId);
        return "redirect:/survey/survey?courseID="+courseId;
    }

    @GetMapping("/survey/disable")
    public String disableSurvey(Model model, @RequestParam("courseID") long courseId)
    {
        surveyAdminDB.disableSurvey(courseId);
        System.out.print("Hiiiii");
        return "redirect:/survey/survey?courseID="+courseId;
    }

}

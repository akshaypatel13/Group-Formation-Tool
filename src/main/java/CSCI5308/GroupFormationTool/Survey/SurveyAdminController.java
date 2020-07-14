package CSCI5308.GroupFormationTool.Survey;

import CSCI5308.GroupFormationTool.AccessControl.CurrentUser;
import CSCI5308.GroupFormationTool.QuestionManager.IQuestionPersistence;
import CSCI5308.GroupFormationTool.QuestionManager.QuestionManagerAbstractFactory;
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
        questionDB = QuestionManagerAbstractFactory.instance().createQuestionDBInstance();
        surveyAdminDB = SurveyAbstractFactory.instance().createSurveyAdminDBInstance();
        surveyManageDB = SurveyAbstractFactory.instance().createSurveyManageDBInstance();
    }

    @GetMapping("/survey/survey")
    public String survey(Model model, @RequestParam("courseID") long courseID)
    {
        surveyAdminDB.createSurvey(courseID);
        boolean check = surveyManageDB.surveyPublishedOrNot(courseID);
        long surveyID = surveyManageDB.findSurveyByCourseID(courseID);
        System.out.print(surveyID);
        model.addAttribute("surveyCheck", check);
        model.addAttribute("courseID",courseID);
        model.addAttribute("surveyQuestions",surveyManageDB.findSurveyQuestions(surveyID));
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
        return "redirect:/survey/survey?courseID="+courseId;
    }

}

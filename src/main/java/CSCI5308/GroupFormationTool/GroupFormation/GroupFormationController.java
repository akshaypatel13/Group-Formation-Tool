package CSCI5308.GroupFormationTool.GroupFormation;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import CSCI5308.GroupFormationTool.SystemConfig;

import CSCI5308.GroupFormationTool.Survey.ISurveyManagePersistence;

@Controller
public class GroupFormationController {

	private static final String courseID = "courseID";
	private ISurveyManagePersistence surveyManageDB;
	private IGroupCreator groupCreator = new DefaultGroupCreator();

	public GroupFormationController() {
		surveyManageDB = SystemConfig.instance().getSurveyManageDB();
	}

	@GetMapping("/formgroups")
	public String loadGroups(Model model, @RequestParam(name = courseID) long courseId) {
		long surveyId = surveyManageDB.findSurveyByCourseID(courseId);
		IGroups groups = new Groups();
		IGroupsPersistence groupDB = new GroupsDB();
		boolean check = false;
		// surveyManageDB.getSurveyGroupAlgo(surveyID);

		// change link to show groups
		// return "redirect:/survey/survey?courseID="+courseId;
		if (Objects.isNull(surveyId)) {
			model.addAttribute("errorMsg", "Survey not created");
		} else {

			check = surveyManageDB.surveyPublishedOrNot(courseId);
			System.out.println(check);
		}
		if (check) {
			model.addAttribute("errorMsg", "Survey not published");

		} else {
			groups.insertGroups(groupDB, surveyId, groupCreator, surveyManageDB);
			Map<Integer, ArrayList<IGroups>> groupInfo = groups.fetchGroups(groupDB);
			model.addAttribute("groupInfo", groupInfo);
		}

		return "groupFormation/group";
	}

}

package CSCI5308.GroupFormationTool.GroupFormation;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import CSCI5308.GroupFormationTool.Survey.ISurveyManagePersistence;
import CSCI5308.GroupFormationTool.Survey.SurveyAbstractFactory;

@Controller
public class GroupFormationController {

	private static final String courseID = "courseID";
	private ISurveyManagePersistence surveyManageDB;
	private IGroupCreator groupCreator;
	private IGroupsPersistence groupDB;

	public GroupFormationController() {
		surveyManageDB = SurveyAbstractFactory.instance().createSurveyManageDBInstance();
		groupDB = GroupsAbstractFactory.instance().createGroupsDBInstance();
		groupCreator = GroupsAbstractFactory.instance().createDefaultGroupCreator();

	}

	@GetMapping("/formgroups")
	public String loadGroups(Model model, @RequestParam(name = courseID) long courseId) {
		long surveyId = surveyManageDB.findSurveyByCourseID(courseId);
		IGroups groups = GroupsAbstractFactory.instance().createGroupsInstance();
		boolean check = false;
		// surveyManageDB.getSurveyGroupAlgo(surveyID);

		// change link to show groups
		// return "redirect:/survey/survey?courseID="+courseId;
		if (Objects.isNull(surveyId)) {
			model.addAttribute("errorMsg", "Survey not created");
		} else {

			check = surveyManageDB.surveyPublishedOrNot(courseId);
		}
		if (check) {
			model.addAttribute("errorMsg", "Survey not published");
			return "groupFormation/notpublished";

		} else {
			groups.insertGroups(groupDB, surveyId, groupCreator, surveyManageDB);
			Map<Integer, ArrayList<IGroups>> groupInfo = groups.fetchGroups(groupDB);
			model.addAttribute("groupInfo", groupInfo);
		}

		return "groupFormation/group";
	}

}

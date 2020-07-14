package CSCI5308.GroupFormationTool.GroupFormation;


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

	public GroupFormationController() {
		surveyManageDB = SystemConfig.instance().getSurveyManageDB();
	}

	@GetMapping("/formgroups")
	public String loadGroups(Model model, @RequestParam(name = courseID) long courseId) {
		long surveyId = surveyManageDB.findSurveyByCourseID(courseId);
		IGroups groups=new Groups();
		IGroupsPersistence groupDB=new GroupsDB();
		boolean check = false;
		if (Objects.isNull(surveyId)) {
			model.addAttribute("errorMsg", "Survey not created");
		} else {

			check = surveyManageDB.surveyPublishedOrNot(courseId);
		}
		if (check) {
			groups.insertGroups(groupDB,surveyId);
            model.addAttribute("courseId", courseId);

		} else {
			model.addAttribute("errorMsg", "Survey not published");
		}

		return "groupFormation/group";
	}

}

package CSCI5308.GroupFormationTool.Survey;

import CSCI5308.GroupFormationTool.QuestionManager.QuestionManagerAbstractFactory;

public class SurveyAbstractFactory implements ISurveyAbstractFactory {

    private static SurveyAbstractFactory uniqueInstance = null;
    private SurveyAdminDB surveyAdminDB;
    private SurveyManageDB surveyManageDB;
    private IGroupCreator groupCreator;

    public static SurveyAbstractFactory instance() {
        if (null == uniqueInstance) {
            uniqueInstance = new SurveyAbstractFactory();
        }
        return uniqueInstance;
    }

    private SurveyAbstractFactory(){
        surveyAdminDB = new SurveyAdminDB();
        surveyManageDB = new SurveyManageDB();
        groupCreator = new DefaultGroupCreator();
    }

    @Override
    public SurveyAdminDB createSurveyAdminDBInstance() {
        return surveyAdminDB;
    }

    @Override
    public SurveyManageDB createSurveyManageDBInstance() {
        return surveyManageDB;
    }

    public IGroupCreator createGroupCreatorInstance(){ return groupCreator; }
}

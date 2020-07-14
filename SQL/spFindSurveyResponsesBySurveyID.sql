DELIMITER $$

DROP PROCEDURE IF EXISTS spFindSurveyResponsesBySurveyID $$

CREATE PROCEDURE spFindSurveyResponsesBySurveyID(
	IN surveyId bigint(20)
)
BEGIN

    SELECT R.questionID, R.userID, R.response
    FROM Response AS R
    JOIN
    (SELECT Survey.surveyId, SurveyQuestions.questionId
    FROM Survey JOIN
    SurveyQuestions
    ON Survey.surveyId = SurveyQuestions.surveyId
    WHERE Survey.surveyID = surveyId) AS sv
    ON R.questionId = sv.questionId;

END$$
DELIMITER ;




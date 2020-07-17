DELIMITER $$

DROP PROCEDURE IF EXISTS spFetchSurveyGroupSize $$

CREATE PROCEDURE spFetchSurveyGroupSize (
	IN surveyID bigint(20)
)
BEGIN
	select groupSize from Survey where surveyId = surveyID limit 1;
END $$

DELIMITER ;
DELIMITER $$

DROP PROCEDURE IF EXISTS spFetchSurveyGroupAlgo $$

CREATE PROCEDURE spFetchSurveyGroupAlgo(
	IN surveyID bigint(20)
)
BEGIN

    select questionId, algo, groupSize
    from GroupAlgo as ga
    join Survey as s
    on ga.surveyId = s.surveyId
    where ga.surveyId = surveyID ;

END$$
DELIMITER ;
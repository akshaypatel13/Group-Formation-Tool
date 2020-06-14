DELIMITER $$

DROP PROCEDURE IF EXISTS spFindQuestionByID $$

CREATE PROCEDURE spFindQuestionByID (
	IN questionID BIGINT
)
BEGIN
	SELECT ques_id, title, description, `type`, date_created
    FROM Questions
    WHERE Questions.ques_id = questionID;
END $$

DELIMITER ;
DELIMITER $$

DROP PROCEDURE IF EXISTS spLoadAllQuestions $$

CREATE PROCEDURE spLoadAllQuestions (
	IN userID BIGINT
)
BEGIN
	SELECT ques_id, title, description, `type`, date_created
    FROM Questions
    WHERE instruct_id = userID;
END $$

DELIMITER ;
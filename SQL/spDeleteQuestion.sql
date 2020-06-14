DELIMITER $$

DROP PROCEDURE IF EXISTS spDeleteQuestion $$

CREATE PROCEDURE spDeleteQuestion (
	IN id BIGINT
)
BEGIN
	DELETE FROM Questions
    WHERE Questions.ques_id = id;
    
	DELETE FROM Response
    WHERE Response.questionID = id;
END $$

DELIMITER ;
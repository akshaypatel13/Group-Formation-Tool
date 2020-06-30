DELIMITER $$
DROP PROCEDURE IF EXISTS spSortQuestionsByCreated $$
CREATE PROCEDURE spSortQuestionsByCreated (
   	IN userID BIGINT
)
BEGIN

	SELECT ques_id, title, description, `type`, date_created
    FROM Questions
    WHERE instruct_id = userID
    ORDER BY date_created;
END $$
DELIMITER ;
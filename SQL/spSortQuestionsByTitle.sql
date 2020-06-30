DELIMITER $$
DROP PROCEDURE IF EXISTS spSortQuestionsByTitle $$
CREATE PROCEDURE spSortQuestionsByTitle (
   	IN userID BIGINT
)
BEGIN

	SELECT ques_id, title, description, `type`, date_created
    FROM Questions
    WHERE instruct_id = userID
    ORDER BY title;
END $$
DELIMITER ;
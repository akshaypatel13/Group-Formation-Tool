DELIMITER $$
DROP PROCEDURE IF EXISTS spSortAllQuestions $$
CREATE PROCEDURE spSortAllQuestions (
	IN sort VARCHAR(255),
   	IN userID BIGINT
)
BEGIN

	SELECT ques_id, title, description, `type`, date_created
    FROM Questions
    WHERE instruct_id = userID
    ORDER BY
	CASE 
	   WHEN sort='title' THEN title
       WHEN sort='created' THEN date_created
	END;
END $$
DELIMITER ;
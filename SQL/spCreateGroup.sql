USE `CSCI5308_21_TEST`;
DROP procedure IF EXISTS `spCreateGroup`;

DELIMITER $$
USE `CSCI5308_21_TEST`$$
CREATE PROCEDURE `spCreateGroup` (IN groupId INT,
surveyId long,
studentId int
)
BEGIN
INSERT INTO courseGroups(group_id,survey_id,student_id) values 
(groupId,surveyId,studentId);
END$$

DELIMITER ;


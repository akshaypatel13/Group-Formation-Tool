USE `CSCI5308_21_TEST`;
DROP procedure IF EXISTS `spFetchGroupsInfo`;

DELIMITER $$
USE `CSCI5308_21_TEST`$$
CREATE PROCEDURE `spFetchGroupsInfo` ()
BEGIN
with studentinfo as(select bannerID,firstName,lastName,userID from User join UserContactInfo using(id))
select * from courseGroups join studentinfo where userID=student_id;
END$$

DELIMITER ;
DELIMITER $$
DROP PROCEDURE IF EXISTS spFindUserByResetToken $$

CREATE PROCEDURE spFindUserByResetToken (
	IN reset_token varchar(255)
)
BEGIN
	SELECT U.id AS id,
		U.bannerID AS bannerID,
		U.password AS password,
        UC.firstName AS firstName,
        UC.lastName AS lastName,
        UC.email AS email
	FROM User U
    JOIN UserContactInfo UC ON (U.id = UC.userID)
    WHERE U.resetToken = reset_token;
END $$

DELIMITER ;
DELIMITER $$

DROP PROCEDURE IF EXISTS spUpdateUserResetToken $$

CREATE PROCEDURE spUpdateUserResetToken (
	IN id BIGINT,
    IN reset_token VARCHAR(255)
)
BEGIN
	UPDATE User U
    SET U.resetToken = reset_token
    WHERE U.id = id;
END $$

DELIMITER ;
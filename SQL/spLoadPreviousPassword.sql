DELIMITER $$

DROP PROCEDURE IF EXISTS spLoadPreviousPassword $$

CREATE PROCEDURE spLoadPreviousPassword (
	IN userID BIGINT,
	IN history INT
)
BEGIN
	SELECT previousPassword
    FROM Password
    WHERE userID = userID
    ORDER BY timestamp desc limit history;
END $$

DELIMITER ;
DELIMITER $$

DROP PROCEDURE IF EXISTS spUpdateUserPassword $$

CREATE PROCEDURE spUpdateUserPassword (
	IN id BIGINT,
    IN password VARCHAR(76)
)
BEGIN
	UPDATE User U
    SET U.password = password
    WHERE U.id = id;

    INSERT INTO Password(userID, previousPassword)
    VALUES (id, password);

END $$

DELIMITER ;
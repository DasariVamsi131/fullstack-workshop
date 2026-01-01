DELIMITER $$

CREATE FUNCTION GetProjectStatus(project_id INT)
RETURNS VARCHAR(20)
DETERMINISTIC
BEGIN
    DECLARE s_date DATE;
    DECLARE e_date DATE;

    -- Get project dates
    SELECT start_date, end_date
    INTO s_date, e_date
    FROM projects
    WHERE id = project_id;

    -- Project not found
    IF s_date IS NULL THEN
        RETURN 'Unknown';
    END IF;

    -- Status calculation
    IF CURDATE() < s_date THEN
        RETURN 'Not Started';
    ELSEIF CURDATE() BETWEEN s_date AND e_date THEN
        RETURN 'In Progress';
    ELSEIF CURDATE() > e_date THEN
        RETURN 'Completed';
    ELSE
        RETURN 'Unknown';
    END IF;
END$$

DELIMITER ;

SELECT
    name,
    start_date,
    end_date,
    GetProjectStatus(id) AS status
FROM projects;

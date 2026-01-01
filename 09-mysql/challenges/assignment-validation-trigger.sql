DELIMITER $$

CREATE TRIGGER trg_validate_assignment
BEFORE INSERT ON assignments
FOR EACH ROW
BEGIN
    DECLARE project_count INT;
    DECLARE total_hours INT;

    -- Count existing projects for the employee
    SELECT COUNT(*)
    INTO project_count
    FROM assignments
    WHERE employee_id = NEW.employee_id;

    -- Calculate total allocated hours for the employee
    SELECT IFNULL(SUM(hours_allocated), 0)
    INTO total_hours
    FROM assignments
    WHERE employee_id = NEW.employee_id;

    -- Rule 1: Max 3 projects
    IF project_count >= 3 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Assignment blocked: Employee already assigned to 3 projects';
    END IF;

    -- Rule 2: Max 2080 total hours
    IF (total_hours + NEW.hours_allocated) > 2080 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Assignment blocked: Total allocated hours exceed 2080';
    END IF;
END$$

DELIMITER ;

INSERT INTO assignments (employee_id, project_id, role, hours_allocated)
VALUES (1, 1, 'Developer', 500);

INSERT INTO assignments (employee_id, project_id, role, hours_allocated)
VALUES (1, 2, 'Developer', 600);

INSERT INTO assignments (employee_id, project_id, role, hours_allocated)
VALUES (1, 3, 'Developer', 700);

INSERT INTO assignments (employee_id, project_id, role, hours_allocated)
VALUES (1, 4, 'Developer', 100);

INSERT INTO assignments (employee_id, project_id, role, hours_allocated)
VALUES (2, 5, 'Analyst', 2100);

SELECT employee_id, COUNT(*) AS project_count, SUM(hours_allocated) AS total_hours
FROM assignments
GROUP BY employee_id;


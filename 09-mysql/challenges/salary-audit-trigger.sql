DELIMITER $$

CREATE TRIGGER trg_salary_audit
AFTER UPDATE ON employees
FOR EACH ROW
BEGIN
    -- Log only when salary changes
    IF OLD.salary <> NEW.salary THEN
        INSERT INTO salary_audit (
            employee_id,
            old_salary,
            new_salary,
            change_percent
        )
        VALUES (
            OLD.id,
            OLD.salary,
            NEW.salary,
            ROUND(
                ((NEW.salary - OLD.salary) / OLD.salary) * 100,
                2
            )
        );
    END IF;
END$$

DELIMITER ;

INSERT INTO employees (name, department, salary, hire_date)
VALUES ('Test Employee', 'IT', 50000.00, '2022-01-01');


UPDATE employees
SET salary = 55000.00
WHERE id = 9;

SET SQL_SAFE_UPDATES = 0;

UPDATE employees
SET salary = 55000.00
WHERE name = 'Test Employee';

UPDATE employees
SET department = 'HR'
WHERE name = 'Test Employee';

SET SQL_SAFE_UPDATES = 1;

SELECT
    audit_id,
    employee_id,
    old_salary,
    new_salary,
    change_percent,
    changed_at
FROM salary_audit;




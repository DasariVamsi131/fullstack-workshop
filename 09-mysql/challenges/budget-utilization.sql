DELIMITER $$

CREATE PROCEDURE GetBudgetUtilization()
BEGIN
    SELECT
        p.name AS project_name,
        p.budget,

        -- Total salary cost based on allocated hours
        ROUND(
            SUM(e.salary * a.hours_allocated / 2080),
            2
        ) AS salary_cost,

        -- Remaining budget
        ROUND(
            p.budget - SUM(e.salary * a.hours_allocated / 2080),
            2
        ) AS remaining,

        -- Utilization percentage
        ROUND(
            (SUM(e.salary * a.hours_allocated / 2080) / p.budget) * 100,
            2
        ) AS utilization_pct

    FROM projects p
    JOIN assignments a
        ON p.id = a.project_id
    JOIN employees e
        ON a.employee_id = e.id

    GROUP BY p.id, p.name, p.budget
    ORDER BY utilization_pct DESC;
END$$

DELIMITER ;

CALL GetBudgetUtilization();

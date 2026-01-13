package collections_streams;

import java.util.*;
import java.util.stream.Collectors;

public class StreamExercise {

    // Employee record (as given)
    record Employee(
            Long id,
            String name,
            String department,
            double salary,
            int yearsOfService,
            List<String> skills
    ) {}

    // Setup employee data
    private static final List<Employee> employees = List.of(
            new Employee(1L, "Alice", "Engineering", 85000, 5, List.of("Java", "Python")),
            new Employee(2L, "Bob", "Engineering", 75000, 3, List.of("Java", "JavaScript")),
            new Employee(3L, "Charlie", "Sales", 65000, 7, List.of("Communication", "CRM")),
            new Employee(4L, "Diana", "Engineering", 95000, 8, List.of("Java", "Kotlin", "Go")),
            new Employee(5L, "Eve", "HR", 55000, 2, List.of("Recruiting", "Communication")),
            new Employee(6L, "Frank", "Sales", 70000, 4, List.of("Negotiation", "CRM"))
    );

    // 1) Filter & Sort: Engineering employees sorted by salary desc
    public static List<String> engineeringSortedBySalaryDesc() {
        return employees.stream()
                .filter(e -> e.department().equalsIgnoreCase("Engineering"))
                .sorted(Comparator.comparingDouble(Employee::salary).reversed())
                .map(Employee::name)
                .collect(Collectors.toList());
    }

    // 2) Map & Collect: employee names uppercase
    public static List<String> allNamesUppercase() {
        return employees.stream()
                .map(Employee::name)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    // 3) Grouping: group employees by department (names)
    public static Map<String, List<String>> groupByDepartment() {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::department,
                        Collectors.mapping(Employee::name, Collectors.toList())
                ));
    }

    // 4a) Total salary expense
    public static double totalSalaryExpense() {
        return employees.stream()
                .mapToDouble(Employee::salary)
                .sum();
    }

    // 4b) Average salary by department
    public static Map<String, Double> averageSalaryByDepartment() {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::department,
                        Collectors.averagingDouble(Employee::salary)
                ));
    }

    // 4c) Highest paid employee
    public static Optional<Employee> highestPaidEmployee() {
        return employees.stream()
                .max(Comparator.comparingDouble(Employee::salary));
    }

    // 5) FlatMap: all unique skills
    public static List<String> uniqueSkills() {
        return employees.stream()
                .flatMap(e -> e.skills().stream())
                .distinct()
                .collect(Collectors.toList());
    }

    // 6) Partitioning: salary > 70000
    public static Map<Boolean, List<String>> partitionBySalaryGreaterThan70000() {
        return employees.stream()
                .collect(Collectors.partitioningBy(
                        e -> e.salary() > 70000,
                        Collectors.mapping(Employee::name, Collectors.toList())
                ));
    }

    // 7) Reduce: total years of service
    public static int totalYearsOfService() {
        return employees.stream()
                .map(Employee::yearsOfService)
                .reduce(0, Integer::sum);
    }

    // 8) Complex: departments where avg salary > 70000
    public static List<String> departmentsWhereAvgSalaryGreaterThan70000() {
        return averageSalaryByDepartment().entrySet().stream()
                .filter(e -> e.getValue() > 70000)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    // Main method showing clear output for each task
    public static void main(String[] args) {

        // 1
        System.out.println("1. " + engineeringSortedBySalaryDesc());

        // 2
        System.out.println("2. " + allNamesUppercase());

        // 3
        System.out.println("3. " + groupByDepartment());

        // 4
        System.out.println("4. Total: $" + (long) totalSalaryExpense()
                + ", Avg by dept: " + averageSalaryByDepartment());

        // 5
        System.out.println("5. " + uniqueSkills());

        // 6
        System.out.println("6. " + partitionBySalaryGreaterThan70000());

        // 7
        System.out.println("7. " + totalYearsOfService() + " years");

        // 8
        System.out.println("8. " + departmentsWhereAvgSalaryGreaterThan70000());
    }
}

// File: oop-advanced/payment/Employee.java

// Employee class represents employee salary payment
// It implements Payable (salary payment) and Taxable (tax calculation)
public class Employee implements Payable, Taxable {

    // Employee details
    private String name;
    private double salary;

    // Constructor initializes employee details
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    // Salary is the payment amount
    @Override
    public double getPaymentAmount() {
        return salary;
    }

    // Calculate tax on salary using Taxable tax rate
    @Override
    public double calculateTax() {
        return salary * Taxable.getTaxRate();
    }

    // Overriding default method to print employee + tax information
    @Override
    public void printPaymentInfo() {
        System.out.println("Employee: " + name);
        System.out.println("Salary: $" + salary);
        System.out.println("Tax (18%): $" + calculateTax());

        // Calling Payable default method
        Payable.super.printPaymentInfo();
        System.out.println("-------------------");
    }
}

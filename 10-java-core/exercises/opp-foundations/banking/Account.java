// File: oop-foundations/banking/Account.java

// Abstract class: common blueprint for all account types
public abstract class Account {

    // Static counter to auto-generate account numbers
    private static int counter = 1000;

    // Common fields for all accounts
    protected int accountNumber;
    protected String holderName;
    protected double balance;

    // Constructor to initialize holder name and starting balance
    public Account(String holderName, double balance) {
        this.accountNumber = ++counter; // auto increment account number
        this.holderName = holderName;
        this.balance = balance;
    }

    // Abstract method: implemented differently by each account type
    public abstract double calculateInterest();

    // Deposit money into account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // Withdraw money (general rule: withdraw only if enough balance)
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    // Returns current balance
    public double getBalance() {
        return balance;
    }

    // Getter for account number
    public int getAccountNumber() {
        return accountNumber;
    }

    // Getter for account holder name
    public String getHolderName() {
        return holderName;
    }
}

// File: oop-foundations/BankAccount.java

public class BankAccount {

    // Static members
    private static String bankName = "MyBank";
    private static int totalAccounts = 0;
    private static int accountCounter = 1000; // for auto account number generation

    // Instance members
    private int accountNumber;
    private String holderName;
    private double balance;

    // Constructor
    public BankAccount(String holderName, double balance) {
        this.holderName = holderName;
        this.balance = balance;

        // auto-generate account number
        this.accountNumber = ++accountCounter;

        // increase total accounts
        totalAccounts++;
    }

    // Static method
    public static String getBankInfo() {
        return bankName + " - Total Accounts: " + totalAccounts;
    }

    // Instance methods
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be greater than 0");
            return;
        }
        balance += amount;
        System.out.println(amount + " deposited successfully.");
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdraw amount must be greater than 0");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient balance!");
            return;
        }
        balance -= amount;
        System.out.println(amount + " withdrawn successfully.");
    }

    public double getBalance() {
        return balance;
    }

    // Main method demonstration
    public static void main(String[] args) {

        BankAccount acc1 = new BankAccount("Alice", 1000);
        BankAccount acc2 = new BankAccount("Bob", 500);

        System.out.println(BankAccount.getBankInfo());
        // MyBank - Total Accounts: 2

        System.out.println(acc1);
        System.out.println(acc2);

        acc1.deposit(200);
        acc1.withdraw(300);
        System.out.println("Acc1 Balance: " + acc1.getBalance());

        acc2.withdraw(1000); // insufficient
    }
}

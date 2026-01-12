// File: oop-foundations/banking/SavingsAccount.java

// SavingsAccount is a type of Account
public class SavingsAccount extends Account {

    // Savings account interest rate (4% per year)
    private static final double INTEREST_RATE = 0.04;

    // Minimum balance required in savings account
    private static final double MIN_BALANCE = 100;

    // Constructor calls parent class constructor
    public SavingsAccount(String holderName, double balance) {
        super(holderName, balance);
    }

    // Interest calculation for savings account
    @Override
    public double calculateInterest() {
        return balance * INTEREST_RATE;
    }

    // Withdraw rule: balance should not go below minimum balance
    @Override
    public void withdraw(double amount) {
        if (amount <= 0) return;

        double remainingBalance = balance - amount;

        // if minimum balance condition fails
        if (remainingBalance < MIN_BALANCE) {
            System.out.println("Withdrawal failed! Minimum balance must be $" + MIN_BALANCE);
            return;
        }

        // withdrawal success
        balance = remainingBalance;
    }
}

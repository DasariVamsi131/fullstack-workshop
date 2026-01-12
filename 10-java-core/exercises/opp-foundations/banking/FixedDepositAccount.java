// File: oop-foundations/banking/FixedDepositAccount.java

// FixedDepositAccount is a type of Account
public class FixedDepositAccount extends Account {

    // FD interest rate (7% per year)
    private static final double INTEREST_RATE = 0.07;

    // Lock period in months (withdrawals not allowed during lock period)
    private static final int LOCK_PERIOD_MONTHS = 12;

    // Constructor calls parent class constructor
    public FixedDepositAccount(String holderName, double balance) {
        super(holderName, balance);
    }

    // Interest calculation for fixed deposit account
    @Override
    public double calculateInterest() {
        return balance * INTEREST_RATE;
    }

    // Withdraw not allowed in FD account
    @Override
    public void withdraw(double amount) {
        // throws exception if user tries to withdraw
        throw new UnsupportedOperationException(
                "Withdrawals not allowed for Fixed Deposit for " + LOCK_PERIOD_MONTHS + " months");
    }
}

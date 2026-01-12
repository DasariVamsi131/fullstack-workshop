// File: oop-foundations/banking/CheckingAccount.java

// CheckingAccount is a type of Account
public class CheckingAccount extends Account {

    // Overdraft limit allowed for checking account
    private static final double OVERDRAFT_LIMIT = 500;

    // Constructor calls parent class constructor
    public CheckingAccount(String holderName, double balance) {
        super(holderName, balance);
    }

    // Checking account has no interest
    @Override
    public double calculateInterest() {
        return 0;
    }

    // Withdraw rule: can withdraw up to (balance + overdraft limit)
    @Override
    public void withdraw(double amount) {
        if (amount <= 0) return;

        double maxWithdrawAmount = balance + OVERDRAFT_LIMIT;

        // overdraft limit validation
        if (amount > maxWithdrawAmount) {
            System.out.println("Withdrawal failed! Overdraft limit exceeded.");
            return;
        }

        // withdrawal success (balance can go negative)
        balance -= amount;
    }
}

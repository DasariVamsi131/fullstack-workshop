// File: oop-foundations/banking/Bank.java

import java.util.ArrayList;
import java.util.List;

// Bank class to manage accounts
public class Bank {

    // Bank name
    private String bankName;

    // Stores all accounts in a list
    private List<Account> accounts;

    // Constructor initializes bank name and account list
    public Bank(String bankName) {
        this.bankName = bankName;
        this.accounts = new ArrayList<>();
    }

    // Add account to bank
    public void addAccount(Account account) {
        if (account != null) {
            accounts.add(account);
        }
    }

    // Find an account using account number
    public Account findAccount(int accountNumber) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber() == accountNumber) {
                return acc;
            }
        }
        return null; // not found
    }

    // Calculate total deposits in bank (sum of balances)
    public double getTotalDeposits() {
        double total = 0;
        for (Account acc : accounts) {
            total += acc.getBalance();
        }
        return total;
    }

    // Return all accounts list
    public List<Account> getAllAccounts() {
        return accounts;
    }

    // Return bank name
    public String getBankName() {
        return bankName;
    }
}

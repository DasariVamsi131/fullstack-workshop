// File: oop-foundations/banking/BankingTest.java

// Main test class for Banking system
public class BankingTest {
    public static void main(String[] args) {

        // Creating bank object
        Bank bank = new Bank("MyBank");

        // Creating different account objects using parent reference (polymorphism)
        Account savings = new SavingsAccount("Alice", 1000);
        Account checking = new CheckingAccount("Bob", 500);
        Account fd = new FixedDepositAccount("Charlie", 10000);

        // Adding accounts to bank
        bank.addAccount(savings);
        bank.addAccount(checking);
        bank.addAccount(fd);

        // Transactions
        savings.deposit(500);
        checking.withdraw(800); // overdraft allowed here

        // Print total deposits in bank
        System.out.println("Total deposits: $" + bank.getTotalDeposits());

        // Print interest for all accounts
        for (Account acc : bank.getAllAccounts()) {
            System.out.println(acc.getHolderName() + " interest: $" + acc.calculateInterest());
        }

        // Try FD withdraw to show exception
        try {
            fd.withdraw(1000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

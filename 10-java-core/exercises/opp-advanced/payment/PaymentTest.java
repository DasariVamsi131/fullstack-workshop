// File: oop-advanced/payment/PaymentTest.java

// PaymentTest class to test polymorphism using Payable interface
public class PaymentTest {
    public static void main(String[] args) {

        // Creating Payable references holding different objects (polymorphism)
        Payable[] payables = {
            new Invoice("P001", "Laptop", 2, 1000),
            new Employee("John", 5000)
        };

        double total = 0;
	for (Payable p : payables) {
    	    p.printPaymentInfo();
    	    total += p.getPaymentAmount();
	}
	System.out.println("Total: $" + total);
    }
}

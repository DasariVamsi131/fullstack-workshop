// File: oop-advanced/payment/Payable.java

// Payable interface represents any entity that can be paid
public interface Payable {

    // Abstract method: must be implemented by classes
    double getPaymentAmount();

    // Default method: provides common implementation for all Payable objects
    default void printPaymentInfo() {
        System.out.println("Payment Amount: $" + getPaymentAmount());
    }
}

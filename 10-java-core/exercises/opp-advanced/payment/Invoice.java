// File: oop-advanced/payment/Invoice.java

// Invoice class represents an invoice payment
// It implements Payable interface because invoice has a payment amount
public class Invoice implements Payable {

    // Invoice details
    private String partNumber;
    private String description;
    private int quantity;
    private double pricePerItem;

    // Constructor initializes invoice details
    public Invoice(String partNumber, String description, int quantity, double pricePerItem) {
        this.partNumber = partNumber;
        this.description = description;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
    }

    // Invoice payment amount = quantity * price per item
    @Override
    public double getPaymentAmount() {
        return quantity * pricePerItem;
    }

    // Overriding default method to print more invoice details
    @Override
    public void printPaymentInfo() {
        System.out.println("Invoice: " + partNumber + " - " + description);
        System.out.println("Qty: " + quantity + ", Price: $" + pricePerItem);

        // Calling Payable default method
        Payable.super.printPaymentInfo();
        System.out.println("-------------------");
    }
}

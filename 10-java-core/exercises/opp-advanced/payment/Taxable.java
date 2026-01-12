// File: oop-advanced/payment/Taxable.java

// Taxable interface represents any entity on which tax can be calculated
public interface Taxable {

    // Abstract method: must be implemented by classes
    double calculateTax();

    // Static method: common tax rate for all Taxable objects
    static double getTaxRate() {
        return 0.18; // 18% tax
    }
}

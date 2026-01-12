// File: oop-advanced/registration/ValidationException.java
import java.util.List;

// Checked exception -> must be handled/declared
public class ValidationException extends Exception {

    private List errors;

    public ValidationException(List errors) {
        this.errors = errors;
    }

    public List getErrors() {
        return errors;
    }
}

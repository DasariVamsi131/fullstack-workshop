// File: oop-advanced/registration/DatabaseException.java

// Checked exception -> DB related error
public class DatabaseException extends Exception {
    public DatabaseException(String message) {
        super(message);
    }
}

// File: oop-advanced/registration/DuplicateUserException.java

// Unchecked exception -> Runtime exception
public class DuplicateUserException extends RuntimeException {
    public DuplicateUserException(String message) {
        super(message);
    }
}

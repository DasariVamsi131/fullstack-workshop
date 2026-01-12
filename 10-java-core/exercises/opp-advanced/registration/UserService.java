// File: oop-advanced/registration/UserService.java
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserService {

    // Simulated DB storage
    private Set emails = new HashSet(); // NO generics

    public UserService() {
        emails.add("existing@email.com"); // already registered
    }

    public void register(User user) throws ValidationException, DuplicateUserException {
        validateUser(user);

        // duplicate check
        if (emails.contains(user.getEmail())) {
            throw new DuplicateUserException("Email already registered");
        }

        // save email
        emails.add(user.getEmail());
    }

    // Required method
    public User findByEmail(String email) throws DatabaseException {

        // try-with-resources usage
        try (FakeDBResource db = new FakeDBResource()) {
            if (email == null) {
                throw new DatabaseException("Email is null");
            }
            return null; // simulated DB
        } catch (DatabaseException e) {
            throw e;
        } catch (Exception e) {
            throw new DatabaseException("Database error");
        }
    }

    // Validate all fields and collect all errors
    private void validateUser(User user) throws ValidationException {
        List errors = new ArrayList(); // NO generics

        // name validation: 2-50 chars
        if (user.getName() == null || user.getName().length() < 2) {
            errors.add("Name too short");
        } else if (user.getName().length() > 50) {
            errors.add("Name too long");
        }

        // email validation format
        if (!isValidEmail(user.getEmail())) {
            errors.add("Invalid email");
        }

        // password validation
        if (!isStrongPassword(user.getPassword())) {
            errors.add("Password too weak");
        }

        // age validation
        if (user.getAge() < 13) {
            errors.add("Must be 13+");
        }

        // throw all errors together
        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }
    }

    private boolean isValidEmail(String email) {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }

    private boolean isStrongPassword(String password) {
        if (password == null || password.length() < 8) return false;
        boolean hasUpper = password.matches(".*[A-Z].*");
        boolean hasNum = password.matches(".*[0-9].*");
        return hasUpper && hasNum;
    }

    // dummy DB resource
    private static class FakeDBResource implements AutoCloseable {
        public void close() { }
    }
}

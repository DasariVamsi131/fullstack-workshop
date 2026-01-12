// File: oop-advanced/registration/UserController.java
import java.util.ArrayList;
import java.util.List;

public class UserController {

    private UserService service = new UserService();

    public Result register(String name, String email, String password, int age) {

        try {
            User user = new User(name, email, password, age);
            service.register(user);
            return Result.success("User registered successfully");

        } catch (ValidationException e) {
            return Result.failure(e.getErrors());

        } catch (DuplicateUserException e) {
            List errors = new ArrayList();
            errors.add(e.getMessage());
            return Result.failure(errors);

        } catch (Exception e) {
            List errors = new ArrayList();
            errors.add("Something went wrong");
            return Result.failure(errors);
        }
    }
}

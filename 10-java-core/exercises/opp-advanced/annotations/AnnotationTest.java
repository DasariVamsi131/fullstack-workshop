// File: oop-advanced/annotations/AnnotationTest.java

import java.util.List;

public class AnnotationTest {
    public static void main(String[] args) {

        User user = new User();
        user.setAge(15); // invalid age, name is null

        List<String> errors = Validator.validate(user);

        System.out.println(errors);
        // [Name is required, Age must be 18-100]
    }
}

// File: oop-advanced/annotations/Validate.java

import java.lang.annotation.*;

// Custom annotation for number range validation
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Validate {
    int min();
    int max();
    String message();
}

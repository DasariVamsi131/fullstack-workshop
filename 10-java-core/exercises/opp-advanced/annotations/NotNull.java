// File: oop-advanced/annotations/NotNull.java

import java.lang.annotation.*;

// Custom annotation for null check validation
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NotNull {
    String message();
}

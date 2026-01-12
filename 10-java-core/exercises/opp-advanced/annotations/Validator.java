// File: oop-advanced/annotations/Validator.java

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

// Validator class to validate object fields using reflection
public class Validator {

    public static List<String> validate(Object obj) {
        List<String> errors = new ArrayList<>();

        if (obj == null) {
            errors.add("Object is null");
            return errors;
        }

        Class<?> cls = obj.getClass();
        Field[] fields = cls.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);

            try {
                Object value = field.get(obj);

                // Check @NotNull
                if (field.isAnnotationPresent(NotNull.class)) {
                    NotNull notNull = field.getAnnotation(NotNull.class);
                    if (value == null) {
                        errors.add(notNull.message());
                    }
                }

                // Check @Validate (min/max)
                if (field.isAnnotationPresent(Validate.class)) {
                    Validate validate = field.getAnnotation(Validate.class);

                    if (field.getType() == int.class || field.getType() == Integer.class) {
                        int num = (value == null) ? 0 : (int) value;
                        if (num < validate.min() || num > validate.max()) {
                            errors.add(validate.message());
                        }
                    }
                }

            } catch (IllegalAccessException e) {
                errors.add("Cannot access field: " + field.getName());
            }
        }

        return errors;
    }
}

// File: oop-advanced/registration/Result.java
import java.util.ArrayList;
import java.util.List;

public class Result {
    private boolean success;
    private String message;
    private List errors = new ArrayList();

    public static Result success(String message) {
        Result r = new Result();
        r.success = true;
        r.message = message;
        return r;
    }

    public static Result failure(List errors) {
        Result r = new Result();
        r.success = false;
        r.errors = errors;
        return r;
    }

    public String toString() {
        if (success) {
            return "Result{success=true, message=" + message + "}";
        }
        return "Result{success=false, errors=" + errors + "}";
    }
}

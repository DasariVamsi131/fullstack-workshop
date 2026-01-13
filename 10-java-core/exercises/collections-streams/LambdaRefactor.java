package collections_streams;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class LambdaRefactor {

    // Helper method (static method reference example)
    public static boolean isEven(Integer n) {
        return n % 2 == 0;
    }

    public static void main(String[] args) {

        List<String> names = new ArrayList<>(List.of("Vamsi", "Anil", "Ravi", "Kumar", "A"));
        List<Integer> numbers = new ArrayList<>(List.of(10, 11, 12, 13, 14, 15));

        // ==========================================================
        // ORIGINAL CODE (IMPERATIVE STYLE)
        // ==========================================================

        // 1. Sort list of strings by length
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        });

        // 2. Filter even numbers
        List<Integer> evens = new ArrayList<>();
        for (Integer n : numbers) {
            if (n % 2 == 0) {
                evens.add(n);
            }
        }

        // 3. Print each element
        for (String s : names) {
            System.out.println(s);
        }

        // 4. Create thread
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Running");
            }
        });
        t.start();

        // 5. Transform strings to uppercase
        List<String> upper = new ArrayList<>();
        for (String s : names) {
            upper.add(s.toUpperCase());
        }

        System.out.println("Original Evens: " + evens);
        System.out.println("Original Upper: " + upper);

        // ==========================================================
        // REFACTORED CODE (FUNCTIONAL STYLE USING LAMBDAS + REFERENCES)
        // ==========================================================

        // Functional Interfaces
        Predicate<Integer> evenPredicate = LambdaRefactor::isEven; // static method reference
        Function<String, String> toUpper = String::toUpperCase;    // instance method reference
        Consumer<String> printer = System.out::println;            // method reference

        // 1. Sort list of strings by length (lambda)
        names.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));

        // 2. Filter even numbers (Predicate + stream)
        List<Integer> evens2 = numbers.stream()
                .filter(evenPredicate)
                .collect(Collectors.toList());

        // 3. Print each element (Consumer + method reference)
        names.forEach(printer);

        // 4. Create thread (lambda)
        Thread t2 = new Thread(() -> System.out.println("Running"));
        t2.start();

        // 5. Transform strings to uppercase (Function + method reference)
        List<String> upper2 = names.stream()
                .map(toUpper)
                .collect(Collectors.toList());

        System.out.println("Refactored Evens: " + evens2);
        System.out.println("Refactored Upper: " + upper2);
    }
}

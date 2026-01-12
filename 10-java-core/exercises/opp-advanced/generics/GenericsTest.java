// File: oop-advanced/generics/GenericsTest.java

import java.util.List;

// Test class for Pair, Box and CollectionUtils
public class GenericsTest {
    public static void main(String[] args) {

        Pair<String, Integer> pair = new Pair<>("Age", 25);
        System.out.println(pair);

        Box<String> box = new Box<>();
        box.set("Hello");
        System.out.println(box.get());

        List<Integer> numbers = List.of(1, 5, 3, 9, 2);
        Integer max = CollectionUtils.findMax(numbers);
        System.out.println("Max: " + max);

        List<String> names = List.of("Alice", "Bob", "Anna");
        List<String> aNames = CollectionUtils.filter(names, s -> s.startsWith("A"));
        System.out.println(aNames);
    }
}

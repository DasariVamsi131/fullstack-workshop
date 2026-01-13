import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectionAnalyzer {

    // Group words by their length
    public static Map<Integer, List<String>> groupByLength(List<String> words) {
        return words.stream()
                .collect(Collectors.groupingBy(String::length));
    }

    // Count frequency of each character across all words
    public static Map<Character, Long> charFrequency(List<String> words) {
        return words.stream()
                .flatMap(word -> word.chars().mapToObj(c -> (char) c))
                .collect(Collectors.groupingBy(
                        ch -> ch,
                        Collectors.counting()
                ));
    }

    public static void main(String[] args) {
        System.out.println(groupByLength(Arrays.asList("hi", "bye", "hello", "ok")));
        // {2=[hi, ok], 3=[bye], 5=[hello]}

        System.out.println(charFrequency(Arrays.asList("aab", "bc")));
        // {a=2, b=2, c=1}
    }
}

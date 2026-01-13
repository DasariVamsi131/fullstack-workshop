import java.util.Objects;

public class Pair<K, V> {

    private final K key;
    private final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    // Swap types and values
    public Pair<V, K> swap() {
        return new Pair<>(value, key);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Pair<?, ?> other)) return false;
        return Objects.equals(key, other.key) &&
               Objects.equals(value, other.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }

    @Override
    public String toString() {
        return "Pair(" + key + ", " + value + ")";
    }

    // Test
    public static void main(String[] args) {
        Pair<String, Integer> pair = new Pair<>("age", 25);

        System.out.println(pair.getKey());        // age
        System.out.println(pair.getValue());      // 25
        System.out.println(pair.swap());          // Pair(25, age)

        Pair<String, Integer> pair2 = new Pair<>("age", 25);
        System.out.println(pair.equals(pair2));   // true
    }
}

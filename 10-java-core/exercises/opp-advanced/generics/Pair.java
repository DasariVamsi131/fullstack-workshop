// File: oop-advanced/generics/Pair.java

import java.util.Objects;

// Generic Pair class to store (key, value)
public class Pair<K, V> {

    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    // getter for key
    public K getKey() {
        return key;
    }

    // getter for value
    public V getValue() {
        return value;
    }

    // setter for key
    public void setKey(K key) {
        this.key = key;
    }

    // setter for value
    public void setValue(V value) {
        this.value = value;
    }

    // equals() override
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair<?, ?>)) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(key, pair.key) && Objects.equals(value, pair.value);
    }

    // hashCode() override
    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }

    // toString() override
    @Override
    public String toString() {
        return "Pair{key='" + key + "', value=" + value + "}";
    }
}

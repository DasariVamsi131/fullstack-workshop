// File: oop-advanced/generics/Box.java

// Generic Box class to store a single item
public class Box<T> {

    private T item;

    // store item
    public void set(T item) {
        this.item = item;
    }

    // get item
    public T get() {
        return item;
    }

    // check if empty
    public boolean isEmpty() {
        return item == null;
    }

    // remove stored item
    public void clear() {
        item = null;
    }
}

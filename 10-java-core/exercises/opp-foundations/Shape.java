// File: oop-foundations/Shape.java
public abstract class Shape {
    public abstract double area();
    public abstract double perimeter();

    public void displayInfo() {
        System.out.println("Area: " + area());
        System.out.println("Perimeter: " + perimeter());
        System.out.println("-------------------");
    }
}

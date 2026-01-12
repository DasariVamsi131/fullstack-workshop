// File: oop-foundations/Person.java

public class Person {

    // Fields (Encapsulation)
    private String name;
    private int age;
    private String email;

    // No-arg constructor
    public Person() {
        this.name = "Unknown";
        this.age = 0;
        this.email = "unknown@email.com";
    }

    // All-args constructor
    public Person(String name, int age, String email) {
        setName(name);
        setAge(age);
        setEmail(email);
    }

    // Getters & Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            this.name = "Unknown";
        } else {
            this.name = name;
        }
    }

    public int getAge() {
        return age;
    }

    // Validation: age must be 0-150
    public void setAge(int age) {
        if (age < 0 || age > 150) {
            System.out.println("Invalid age! Age must be between 0 and 150.");
        } else {
            this.age = age;
        }
    }

    public String getEmail() {
        return email;
    }

    // Validation: email must contain '@'
    public void setEmail(String email) {
        if (email == null || !email.contains("@")) {
            System.out.println("Invalid email! Email must contain '@'.");
        } else {
            this.email = email;
        }
    }

    // toString method
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", email='" + email + "'}";
    }

    // Main method demonstration
    public static void main(String[] args) {

        // Person p1 using no-arg constructor
        Person p1 = new Person();
        System.out.println(p1);

        // Person p2 using all-args constructor
        Person p2 = new Person("John", 25, "john@email.com");
        System.out.println(p2);

        // Update age
        p2.setAge(30);
        System.out.println(p2);

        // Validation testing
        p2.setAge(200);              // invalid age
        p2.setEmail("johnemail.com"); // invalid email
    }
}

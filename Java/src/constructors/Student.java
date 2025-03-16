package constructors;

// Simple class
public class Student {
    String name;
    int age;
    String location;

    // Constructor
    // A special type of method used to initialize objects using this class
    // Use the exact class name
    public Student(String name, int age, String location) {
        this.name = name;
        this.age = age;
        this.location = location;
        // this.variable refers to the property for the Class
    }

    // Getters and setters
    // Naming convention - get<PropertyName>, set<PropertyName>
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String showDetails() {
        String details = String.format("Student %s from %s is %d years old.", name, location, age);
        return details;
    }

    public static void main(String[] args) {
        Student s1 = new Student("Manu", 33, "Bangalore");
        // Update the age using setter
        s1.setAge(34);
        System.out.println(s1.showDetails());
    }
}

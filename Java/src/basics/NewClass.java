package basics;

public class NewClass{
    int x = 10;
    // Private variables cannot be accessed from outside this class
    private int y = 20;

    void printHello() {
        System.out.println("Hello from another class");
    }

    // Private methods cannot be accessed from outside this class
    private void printNothing() {
        System.out.println("In a private method");
    }

}
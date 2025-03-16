package constructors;

// AN example with no constructor
public class Square {
    int num;

    int sq() {
        return num * num;
    }

    public static void main(String[] args) {
        // Square x = new Square(5); You cannot specify arguments since there is no constructor
        Square x = new Square();
        // Using a method in this case will just return 0
        System.out.println(x.sq()); // It uses the default initialised value of 0 for num
    }
}

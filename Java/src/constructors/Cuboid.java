package constructors;

// Using multiple constructors
public class Cuboid {
    int height;
    int width;
    int depth;

    // Primary constructor
    // Any object using this is expected to provide all 3 parameters.
    public Cuboid(int height, int width, int depth) {
        this.height = height;
        this.width = width;
        this.depth = depth;
    }

    // Suppose the depth is a constant.
    // Instead of having to pass a constant value everytime, you can create a second constructor
    // Use the same class name for the 2nd constructor as well
    public Cuboid(int height, int width) {
        this.height = height;
        this.width = width;
        this.depth = 10;
    }

    // Suppose all 3 parameters are expected to be the same value
    // Create a 3rd constructor, which accepts just one argument
    public Cuboid(int dimension) {
        this.height = dimension;
        this.width = dimension;
        this.depth = dimension;
        // It is not necessary to specify "this" here since the arguments have a different name
    }

    // Now a 4th constructor where you don't need to specify any argument. All are defaulted to 10.
    public Cuboid() {
        this.height = 10;
        this.width = 10;
        this.depth = 10;
    }

    int volume() {
        return height * width * depth;
    }

    public static void main(String[] args) {
        // Using the default constructor
        Cuboid c1 = new Cuboid(8, 8, 8);
        System.out.println(c1.volume());
        // Now passing just 2 parameters (height and width)
        Cuboid c2 = new Cuboid(9, 9);
        System.out.println(c2.volume());
        // Now passing just 1 parameter (dimension), which will be used for all 3
        Cuboid c3 = new Cuboid(5);
        System.out.println(c3.volume());
        // Now the 4th option of not passing any arguments
        Cuboid c4 = new Cuboid();
        System.out.println(c4.volume());
    }
}

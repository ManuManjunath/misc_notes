void main() {
  print("Classes\n--------------------");

  // Instantiate the class
  final cookie = Cookie("Circle", 15.2);
  // or Cookie cookie = Cookie();
  print(cookie.runtimeType);
  print(cookie.shape);
  print(cookie.size);
  // Cannot modify shape since it is a final variable
  // cookie.shape = "Square";
  cookie.size = 14.5;
  print(cookie.size);
  print(cookie.flavour());

  // Private variables can be accessed within this file.
  print(cookie._color);
  print(cookie.color);
  cookie._color = "White"; // Why is this allowed?
  print(cookie._color);
  print(cookie.color);
  cookie.setColor = "Red";
  print(cookie._color);
  print(cookie.color);

  // Static proeprties from a class can be called without initializing the class
  // Cake cake = Cake(); // Need not initialize
  // print(cake.weight); // The static getter weight can't be accessed through an instance
  print(Cake.weight); // This doesn't call the constructor
  print(Cake.weightOf2Cakes());

  // Non statuc methods cannot be accessed without initializing
  // print(Cake.weightOf3Cakes());
}

class Cookie {
  // Properties or Variables
  final String shape;
  double size;
  // Private variables start with an underscore.
  // They're not private for the class. But private for the file.
  String _color = "Brown";

  // Constructor
  Cookie(this.shape, this.size) {
    print("Initializing a $_color Cookie");
  }

  // Getter for private variable
  String get color => _color;

  // Setter for private variable
  set setColor(String col) {
    _color = col;
  }

  // Methods
  String flavour() {
    return "Chocolate";
  }

  bool bakedAndReady() {
    return false;
  }
}

class Cake {
  // Static proeprties from a class can be called without initializing the class
  static final double weight = 0.5;
  Cake() {
    print("Initializing a new Cake");
  }

  // Static methods can also be accessed without initializing the class
  static double weightOf2Cakes() {
    return 2 * weight;
  }

  // If a method is not static, it cannot be accessed without initializing the class
  double weightOf3Cakes() {
    return 3 * weight;
  }
}

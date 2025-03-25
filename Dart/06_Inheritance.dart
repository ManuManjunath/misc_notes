void main() {
  print("Inheritance\n--------------------");
  Car car = Car();
  print("\nCar\n---------");
  print(car.wheels);
  // You can also view properties/methods in the parent class
  print(car.engineWorking);
  print(car.speed);
  // If the same method is present in the parent class and child class, it uses the child class.
  car.accelerate();
  // If accelerates using the value in Car rather than Vehicle class.
  print(car.speed);

  // If you want to use the method from parent class, use super
  car.accelerate2();
  // Now it accelerates using the value in Vehicle rather than Car
  print(car.speed);

  // You can also initialize a car as a Vehicle type
  Vehicle car2 = Car();
  // But if you want to access properties/methods from Car class instead of Vehicle (wheels in this case), use the below format
  print((car2 as Car).wheels);

  Parrot parrot = Parrot();
  print("\nParrot\n---------");
  print(parrot.domestic);
  print(parrot.legs);
  
  Charriot charriot = Charriot();
  print("\nCharriot\n---------");
  print(charriot.engineWorking);
  print(charriot.speed);
  charriot.accelerate();
  print(charriot.speed);
}

class Vehicle {
  int speed = 10;
  bool engineWorking = true;

  void accelerate() {
    speed += 10;
  }

  void accelerate2() {
    print("Accelerating Vehicle");
    speed += 10;
  }
}

class Car extends Vehicle {
  // "extends" will allow you to use all properties/methods from the parent class
  int wheels = 4;

  void accelerate() {
    print("Accelerating Car");
    speed += 20;
  }

  void accelerate2() {
    print("What is this accelerating?");
    super.accelerate2();
  }
}

class Animal {
  int legs = 4;
  bool domestic = false;
}

class Parrot implements Animal {
  // If we use "implements" instead of extends, we need to redefine all the properties/methods.
  int legs = 2;
  
  @override
  bool domestic = true;
  
  // Is it optional to add @override?
}

class Charriot extends Vehicle implements Animal {
  // Using both extends and implements together
  // We need to override all properties/methods of "implements" class
  @override 
  int legs = 4;
  
  @override
  bool domestic = true;
  
  // Optional to add "@override" properties/methods of "extends" class
  bool engineWorking = false;
  int speed = 20;
  
  void accelerate() {
    print("Accelerating Charriot..");
    speed += 5;
  }
}

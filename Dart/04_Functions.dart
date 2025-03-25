void main() {
  print("Functions\n--------------------");

  print(sq(5));

  // Calling a void function
  cube(5);

  var sc = sqAndCube(3);
  print(sc.$1);
  print(sc.$2);

  // Another way
  var (x1, x2) = sqAndCube(10);
  print(x1);
  print(x2);
  
  // Yet another way
  var squareAndCube = sqAndCube2(4);
  print(squareAndCube.squareIt);
  print(squareAndCube.cubeIt);

  var y = nullable();
  print(y);

  String candidateName = "John Doe";
  int candidateAge = 100;

  print(namedArgs(age: candidateAge, name: candidateName));
  // Need not pass arguments in the required order since they're named.
}

int sq(int x) {
  return x * x;
}

void cube(int x) {
  print(x * x * x);
}

(int, int) sqAndCube(x) {
  return (x * x, x * x * x);
}

String? nullable() {
  return null;
  //or return "a";
}

String namedArgs({
  required String name,
  required int age,
  String location = "Bangalore",
}) {
  return "$name from $location is $age years old";
}

void namedPlusPositionalArgs(String title, int age, {
  required String name,
  String location = "Bangalore"
}) {
  
}

({int squareIt, int cubeIt}) sqAndCube2(x) {
  return (squareIt: x * x, cubeIt: x * x * x);
}

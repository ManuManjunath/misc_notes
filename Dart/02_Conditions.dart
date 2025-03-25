void main() {
  print("Control Flow\n--------------------");
  dynamic num = 8;

  if (num % 2 == 0 && num % 3 == 0) {
    print("$num is divisibe by 6");
  } else if (num % 2 == 0 && num % 3 != 0) {
    print("$num is divisible by 2 but not 3");
  } else if (num % 3 == 0 && num % 2 != 0) {
    print("$num is divisible by 3 but not 2");
  } else {
    print("$num is not divisible by 2 or 3");
  }

  String evenOrOdd = (num % 2 == 0) ? "Even" : "Odd";
  print(evenOrOdd);

  // Switch
  switch (num) {
    case "8":
      print("String 8");
    case true:
      print("Boolean");
    case 8:
      print("Number 8");
    default:
      print("Unknown");
  }
}

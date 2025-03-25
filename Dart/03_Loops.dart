void main() {
  print("Loops\n--------------------");
  
  for (int i = 1; i <= 5; i++) {
    print(i);
  }
  
  String hello = "Hello";
  for (int i = 0; i < hello.length; i++) {
    print(hello[i]);
  }
  
  int i = 5;
  while(i > 0) {
    print(i);
    i--;
  }
  
  do {
    print(i);
    i++;
  } while (i <= 5);
  
  var list = [1, 2, 3];
  for (var i in list) {
    print(i * i);
  }
  
}

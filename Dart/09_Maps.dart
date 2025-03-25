void main() {
  print("Maps\n--------------------");

  Map<int, String> m1 = {0: "Zero", 1: "One", 2: "Two"}; 
  
  // Without specifying types or Key and Value
  Map m2 = {0: true, false: "One", 3.5: "WORKS"};
  print(m2);
  
  // To create a copy
  Map m3 = Map.of(m1);
  print(m3);
  
  // Using lists
  List<String> keys = ["key1", "key2", "key3"];
  List<String> values = ["value1", "value2", "value3"];
  Map<String, String> m4 = Map.fromIterables(keys, values);
  print(m4);

  print("ADDING");
  m4["key4"] = "value4";
  print(m4);
  // Another way
  m4.putIfAbsent("key4", () => "value4");
  print(m4);
  m4.putIfAbsent("key5", () => "value5");
  print(m4);
  
  print("UPDATING");
  m4["key4"] = "new Value4";
  print(m4);
  // Another way
  m4.update("key5", (i) => "new Value5");
  print(m4);
  // using Update ifAbsent
  m4.update("key5", (i) => "value5", ifAbsent: () => "VALUE5");
  print(m4);
  m4.update("key6", (i) => "value6", ifAbsent: () => "VALUE6");
  print(m4);
  
  print("REMOVING");
  Map m5 = {1: 'one', 2: 'two', 3: 'three', 4: 'four', 5: 'five'};
  m5.remove(2);
  print(m5);
  m5.removeWhere((k, v) => v.startsWith('f'));
  print(m5);
  m5.clear();
  print(m5);

  // Looping
  m1.forEach((k, v) {
    print("key is $k, vaue is $v");
  });
  
}

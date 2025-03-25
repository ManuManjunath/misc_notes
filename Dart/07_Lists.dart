void main() {
  print("Lists\n--------------------");

  // Without specifying datatype (dynamic)
  List l1 = [10, 20, 30, "A", false];
  print(l1[l1.length - 1]);
  // Or use .last
  print(l1.last);
  // Sublists - Starting index is inclusive. Ending index is not.
  print(l1.sublist(2, 4));
  print(l1.reversed);
  l1.shuffle();
  print(l1);
  print(l1.asMap());
  // Only get specific data types
  print(l1.whereType<bool>());

  List<double> l2 = [95, 94.5, 98.6];
  print(l2);

  // replacing
  l2[2] = 100;
  print(l2);
  // add
  l2.add(92.4);
  print(l2);
  // remove
  l2.remove(100);
  print(l2);
  // Filter
  print(l2.where((i) => i < 95));
  
  // Some more methods
  // fold, reduce, getRange, replaceRange, followedBy, firstWhere, etc
  
  // Looping
  for (double e in l2) {
    print(e.round());
  }
}

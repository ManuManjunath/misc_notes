void main() {
  print("Sets\n--------------------");

  // Creating a set
  var halogens = {'fluorine', 'chlorine', 'bromine', 'iodine', 'astatine'};
  
  // Creating an empty set
  var elements = <String>{};
  elements.add('fluorine');
  elements.addAll(halogens);
  
  // Removed duplicates
  print(elements);
  
  for (var i in elements) {
    print(i);
  }
  
  print(elements.contains('chlorine'));
  print(elements.elementAt(1));
  elements.remove('chlorine');
  print(elements.elementAt(1));
  
  // Convert to list
  List<String> elementsList = elements.toList();
  print(elementsList);

}

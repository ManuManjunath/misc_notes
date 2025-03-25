void main() {
  print("Variables and Types\n--------------------");
  int v1 = 10;
  double v2 = 10.0;
  bool check = v1 == v2;
  print(v1 + v2);
  print(check);
  // int 10 = double 10.0
  dynamic v4 = "one";
  v4 = 1;
  v4 = false;
  print(v4);

  // To check the types
  print("${v1} is ${v1.runtimeType}, ${v4} is ${v4.runtimeType}");

  /*
  multi
  line
  comment
  */

  String mls = """
  multi
  line
  string
  """;

  print(mls);

  // var/final/const
  var x1 = "10";
  final x2 = "10";
  const x3 = "10";

  print(
    "${x1} is ${x1.runtimeType}, ${x2} is ${x2.runtimeType}, ${x3} is ${x3.runtimeType}",
  );

  // vars can be reassigned
  x1 = "11";

  // final/const cannot be reassigned - immutablw
  // x2 = "11";
  // x3 = "11";

  // Final vs Const
  // Final is a runtime conatant.
  // Const is a compile time constant
  final x4 = DateTime.now();
  // Cannot run this
  // const x5 = DateTime.now();
  print(x4);

  // Operating on strings
  print("2" + "3");
  print("2" * 3);

  // Nullable
  // var can be null. However, if we want String/int/double/etc to be nullable, use the below format:
  String? nullableString = null;
  print(nullableString);
  // Need not initialize to null - if its marked as nullable (?) It takes default value as null.
  String? nullableString2;
  print(nullableString2);

  // To show the property of a nullable variable
  print(nullableString2?.length);
  print(nullableString2?.length ?? "EmptyString");
  // Lets reassign and try again

  nullableString2 = "x";
  print(nullableString2?.length);
  print(nullableString2?.length ?? "EmptyString");
}

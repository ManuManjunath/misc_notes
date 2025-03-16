package basics;

public class Variables {

    // Declare global variables here outside the Main method
    static int globalVar1 = 10;
    // You won't be able to use this without the "static" keyword.
    int globalVar2 = 20;
    // Cannot use globalVar2 because it is not static

    public static void main(String[] args) {
        int myVar;
        myVar = 50;
        int anotherVar = 100;
        myVar = anotherVar;
        System.out.println(myVar);
        // Using "final" to freeze variables
        final int newVar = 10;
        // The below line won't work -
        // newVar = 20;

        // Float
        float pi = 3.14f;

        // Characters
        char smallChar = 'U';
        // Strings
        String name = "Manu";
        System.out.println("Hello " + name);

        // Using global variables declared outside
        System.out.println(globalVar1);
        // System.out.println(globalVar2);

        // Arithmetic operations
        int a = 7;
        int b = 2;
        System.out.println(a/b); // Removes the decimal part
        // Prefix and postfix
        int someInt = 5;
        System.out.println(++someInt); //Increments the variable by 1 and then displays it
        System.out.println(someInt); // The variable's original value is changed
        int someOtherInt = 5;
        System.out.println(someOtherInt++); // Displays original value before incrementing
        System.out.println(someOtherInt); // The variable's original value is changed
        int newInt = 50;
        newInt -= 5;
        System.out.println(newInt); // 50 - 5
        int newVarAgain = 100;
        int x = 5;
        int y = 2;
        newVarAgain /= x * y;
        System.out.println(newVarAgain); // 100 / (5 * 2)

        // Integer to Float
        int intA = 5;
        float floatA = (float) intA;
        System.out.println(floatA); // 5 is shown as 5.0
        // Float to Integer
        float floatB = 4.2f;
        int intB = (int) floatB;
        System.out.println(intB); // 4.2 is shown as 4
        // Or directly convert integers to float for calculations like this -
        System.out.println((float) intA / (float) intB);

        // Boolean
        boolean human = true;

        // String comparison
        String s1 = "This is";
        s1 += " a String";
        String s2 = "This";
        s2 += " is a String";
        System.out.println(s1);
        System.out.println(s2);
        // Strings are immutable.
        // String variables are stored in a separate string instance.
        // Although both Strings have the same values, the underlying instance for s1 and s2 are different
        if (s1 == s2) { // When you directly compare s1 and s2, it checks if the reference objects are the same
            System.out.println("Both Strings are the same");
        } else {
            System.out.println("The Strings are different");
        }
        if (s1.equals(s2)) { // Use "equals" to check if the values of the Strings are the same
            System.out.println("Both Strings are the same");
        } else {
            System.out.println("The Strings are different");
        }
        // Convert other types to String -
        int convertToString = 100;
        String convertedToString = String.valueOf(convertToString);
        System.out.println(convertedToString.getClass().getName());
        // Other String functions
        // length, concat, replace, toLowerCase, toUpperCase, trim, split,
        // charAt, substring, contains, endsWith, startsWith, indexOf, lastIndexOf,
        // equals, equalsIgnoreCase, isEmpty, compareTo, compareToIgnoreCase, format

        // String formatting
        String location = "Bangalore";
        int flightNum = 174;
        String time = "09:00";
        double someDecimal = 10.367777f;
        String formatString = String.format("I travelled to %s on Flight number %d at %s", location, flightNum, time);
        System.out.println(formatString);
        String formatDecimals = String.format("Decimal formatter 10.367777f is %.1f for 1 decimal point", someDecimal);
        System.out.println(formatDecimals);
        /* Other formatting options -
        %d - Decimal numbers - 32 is 32
        %x - Hex numbers - 32 is 20
        %f - floating decimals - %.xf shows x number of decimal points
        %s - Strings
        %c - character
        */

        // Type conversion
        int a1 = 10;
        long b1 = a1; // Can easily convert to an type with a larger bucket
        int c1 = (int)b1; // To convert back to smaller bucket, use (type)
        System.out.println(c1);
        double d1 = 50.5d;
        int e1 = (int) d1; // Converting double to int
        System.out.println(e1);
    }
}

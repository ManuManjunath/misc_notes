package basics;

public class Conditions {
    public static void main(String[] args) {
        int value1 = 10;
        int value2 = 8;
        int maxValue = value1 > value2 ? value1 : value2;
        // If true, maxValue = value1 = 10. Else, 8.
        // If-else
        if (value1 > value2) {
            System.out.println(value1 + " is greater then " + value2);
        } else if (value2 > value1) {
            System.out.println(value2 + " is greater then " + value1);
        } else {
            System.out.println("They're both same");
        }
        // Multiple conditions
        // and
        int divisibleBy6 = 24;
        if (divisibleBy6 % 2 == 0 && divisibleBy6 % 3 == 0) {
            System.out.println(divisibleBy6 + " is divisible by 6");
        }
        // or
        String someString = "Ugly";
        if (someString == "Good" || someString == "Bad") {
            System.out.println("Not Ugly");
        } else {
            System.out.println(someString);
        }
        boolean done = false;
        if (!done) { // This will resolve to - if (true)
            System.out.println("Not done");
        }
        // Another way
        double numerator = 10.0d;
        double denominator = 2.0d;
        double division = denominator != 0 ? numerator / denominator : 0.0d;
        System.out.println("Division value = " + division);
    }
}

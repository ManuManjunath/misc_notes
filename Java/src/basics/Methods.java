package basics;

import java.util.*;

public class Methods {

    public static void main(String[] args) {
        int toCube = 3;
        // Now call the cubeIt method, which returns the cube integer for a given integer.
        System.out.println(cubeIt(toCube));

        // Using another class - NewClass.java
        NewClass nc = new NewClass();
        System.out.println("Printing value from another class - " + nc.x);
        nc.printHello();
    }

    private static int cubeIt(int toCube) {
        // The "int" before the method name is specify the return type
        // If there is no specific return type, it'll be "private/public static void"
        return toCube * toCube * toCube;
    }

}

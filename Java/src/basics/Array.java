package basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Array {
    public static void main(String[] args) {
        System.out.println("Arrays........");
        float[] array1 = new float[3]; // This is a 3 element array for floats.
        array1[0] = 10.0f;
        array1[1] = 11.3f;
        array1[2] = 12.4f;
        // Index out of bounds if you run --> array1[4] = 2.5f;
        float total = 0.0f;
        for (int index = 0; index < array1.length; index++) {
            total += array1[index];
        }
        System.out.println(total);
        // or use enhanced for like this -
        float[] array2 = {10.0f, 11.3f, 12.4f};
        float total2 = 0.0f;
        for (float currentVal: array2) {
            total2 += currentVal;
        }
        System.out.println(total2);
        double[] height = {3.0f, 8.0f, 9.0f};
        double[] width = {4.0f, 6.0f, 12.0f};
        double[] hypotenuse = new double[height.length];
        for (int i = 0; i <width.length; i++) {
            hypotenuse[i] = Math.sqrt((height[i] * height[i]) + width[i] * width[i]);
            System.out.println("Hypotenuse is " + hypotenuse[i] + " For sides " + height[i] + " and " + width[i]);
        }
        System.out.println(java.util.Arrays.toString(hypotenuse));

        System.out.println("2D array........");
        int[][] arr2d = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j <3; j++) {
                System.out.print(arr2d[i][j] + " ");
            }
            System.out.println();
        }
    }
}

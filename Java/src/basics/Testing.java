package basics;

import java.util.Arrays;

public class Testing {

    public static void main(String[] args) {

        int[] numbers = new int[5];
        numbers[0] = 10;
        numbers[1] = 20;
        numbers[2] = 30;
        numbers[3] = 40;
        numbers[4] = 50;

        System.out.println(Arrays.toString(numbers));
        System.out.println(numbers[2]);

        int[][] arr2d = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j <3; j++) {
                System.out.print(arr2d[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(Arrays.toString(arr2d));

        
    }
}

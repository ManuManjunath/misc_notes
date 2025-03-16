package misc;

import java.util.Random;

public class Recursive {
    public static void main(String[] args) {
        Random r = new Random();
        int lower = 1;
        int higher = 101;
        int original = r.nextInt(higher-lower) + lower;
        System.out.println("Original number is " + original);
        System.out.println("Lets try to guess it");
        int attempt = 0;
        guess(lower, higher, attempt, original);
    }

    private static void guess(int lower, int higher, int attempt, int original) {
        Random r = new Random();
        int guessedValue = r.nextInt(higher-lower) + lower;
        attempt ++;
        if (guessedValue == original) {
            System.out.println(guessedValue + " is right. You guessed it in " + attempt + " attempts");
        } else if (guessedValue > original) {
            int newHigher = guessedValue - 1;
            System.out.println(guessedValue + " is higher. Try again with new limits: " + lower + " to " + newHigher);
            guess(lower, newHigher, attempt, original);
        } else {
            int newLower = guessedValue + 1;
            System.out.println(guessedValue + " is lower. Try again with new limits: " + newLower + " to " + higher);
            guess(newLower, higher, attempt, original);
        }

    }


}

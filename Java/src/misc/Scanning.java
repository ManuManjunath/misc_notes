package misc;

import java.util.Scanner;

public class Scanning {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // Scanning a single word
        System.out.println("enter name");
        String name = scan.next();
        System.out.printf("Hello %s\n", name);
        // Scanning a number
        System.out.println("enter a number");
        int num = scan.nextInt();
        int twice = num * num;
        System.out.printf("its square is %d\n", twice);
        // Scanning multiple words of a sentence
        System.out.println("enter full name");
        String fName = scan.next();
        fName += scan.nextLine();
        System.out.printf("Hello %s\n", fName);
    }
}

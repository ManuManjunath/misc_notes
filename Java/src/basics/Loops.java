package basics;

public class Loops {
    public static void main(String[] args) {
        System.out.println("While loop - ");
        int myNum = 5;
        int factorial = 1;
        while (myNum > 0) {
            factorial *= myNum;
            myNum--;
        }
        System.out.println(factorial); // Prints 120 - 5*4*3*2*1
        System.out.println("Do-While loop - ");
        myNum = 5;
        factorial = 1;
        do {
            System.out.println(myNum);
            factorial *= myNum;
            myNum--;
        } while (myNum > 1);
        System.out.println(factorial);
        System.out.println("For loop - ");
        for (int forInt = 0; forInt <5 ; forInt++) {
            System.out.println(forInt);
        }
        // For loop on array
        String[] arr1 = {"User1", "User2", "User3"};
        for (int Index = 0; Index < arr1.length; Index++) {
            System.out.println(arr1[Index]);
        }
        // Simpler way
        for (String element : arr1) {
            System.out.println(element);
        }
    }
}

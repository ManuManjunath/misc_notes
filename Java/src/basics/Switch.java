package basics;

public class Switch {
    public static void main(String[] args) {
        char forSwitch = 'm';
        switch (forSwitch) { // The variable goes in the switch statement
            case 'a':
                System.out.println("a for Addition");
                break;
            case 's':
                System.out.println("s for Subtraction");
                break;
            case 'm':
                System.out.println("m for Multiplication");
                //break;
            case 'd':
                System.out.println("d for Division");
                break;
            default:
                System.out.println("Unknown code");
        }
    }
}

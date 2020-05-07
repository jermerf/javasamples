import java.util.Scanner;

public class SwitchStatements {

    public static void main(String[] args) {
        System.out.println("Make a choice:");
        System.out.println("1) Critique my age");
        System.out.println("2) Critique my favourite colour");
        System.out.println("3) Scream!");

        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        input.nextLine();


        switch (choice) {
            case 1:
                System.out.println("How old are you?");
                int age = input.nextInt();
                if(age > 32) {
                    System.out.println("You is old");
                } else {
                    System.out.println("You is just a young'un");
                }
                break;
            case 2:
                System.out.println("What is your favourite colour?");
                String col = input.nextLine();
                if(col.equalsIgnoreCase("green")) {
                    System.out.println("That's very in season");
                } else {
                    System.out.println("That's an ok colouuuur");
                }
                break;
            case 3:
                System.out.println("AHHH!! The prices! The toiletpaper!!");
                break;
            default:
                System.out.println("Invalid choice, what's up with that!?");
        }
        System.out.println("Switching complete. Excellent");
    }
}



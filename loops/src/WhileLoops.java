import java.util.Scanner;

public class WhileLoops {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int repeat = 10;
        while(repeat > 0){
            System.out.println(repeat);
            repeat--;
        }


        int repeatForward = 0;
        while(repeatForward < 10) {
            System.out.println(repeat);
            repeatForward++;
        }

        boolean keepGoing = true;
        // infinite loop
        /*
        while(keepGoing) {
            System.out.println("Hello world");
        }
        */

        while(keepGoing) {
            System.out.println("Should I keep going?");
            String response = input.nextLine();
            keepGoing = response.equalsIgnoreCase("y");
        }

        int tooSmall = 0;
        while(tooSmall > 100){ // Never true
            System.out.println("You never see this message");
        }
        System.out.println("..all done");
    }
}

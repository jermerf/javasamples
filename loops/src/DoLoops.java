import java.util.Scanner;

public class DoLoops {

    public static void main(String[] args){
//        while(){}
//        for( ; ; ){}
//        do{ ... } while();
        Scanner input = new Scanner(System.in);

        boolean keepPlaying = false;
        do {

            int secret = (int) Math.ceil(Math.random() * 5);
            int guess = 0;

            boolean breakOut = false;
            while (guess != secret) {
                System.out.println("Make a guess");
                guess = input.nextInt();
                if(guess == 32) {
                    breakOut = true;
                    break;
                }
            }
            if(breakOut) break;
            System.out.println("The secret was: " + secret);
            System.out.println("Would you like to play again? (y/n)");
            keepPlaying = input.next().equalsIgnoreCase("y");
        }while(keepPlaying);
    }
}

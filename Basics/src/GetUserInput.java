import java.util.Scanner;

public class GetUserInput {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("How old are you?");
        int age = input.nextInt();

        for(int i=0; i < age; i++) {
            System.out.println("Note for year " + i);
        }
    }

}

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Server or client?\n" +
                "1) Server\n" +
                "2) Client");

        if(input.nextInt() == 1) {
            new SimpleSocketServer();
        }else{
            new SimpleSocketClient();
        }
    }
}

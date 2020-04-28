import java.util.Scanner;

public class Five31 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Ballance: ");
        double ballance = input.nextDouble();
        System.out.println("Annual Interest Rate: ");
        double annualInterest = input.nextDouble() / 100;
        System.out.println("Term months: ");
        int months = input.nextInt();

        double monthlyInterest = annualInterest / 12;

        for(int i=1; i<=months; i++) {
            ballance += ballance * monthlyInterest;

            System.out.println(i + "\t" + Math.round(ballance*100)/100.0);
        }

    }
}

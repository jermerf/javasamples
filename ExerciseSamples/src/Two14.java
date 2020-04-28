import java.util.Scanner;

public class Two14 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Weight in pounds:");
        double weightLbs = input.nextDouble();
        System.out.println("Height in inches:");
        double heightIn = input.nextDouble();

        // lbs to kg
        double kg = weightLbs / 2.2;

        // in to m
        double m = heightIn * 0.0254;

        double bmi = kg / (m*m);
        System.out.println("BMI: " + bmi);

    }
}

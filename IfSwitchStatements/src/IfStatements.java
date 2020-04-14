import java.util.Scanner;

public class IfStatements {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("How old are you?");
        int age = input.nextInt();
        System.out.println("You are " + age);

        // Just IF
        if(age >= 18){
            System.out.println("You are legal voting age");
        }

        // IF-ELSE
        if(age >= 18){
            System.out.println("You are legal voting age");
        } else {
            System.out.println("You are TOO YOUNG to vote");
        }

        // IF-ELSEIF
        // <18 TOO YOUNG, 18-60 WORKING AGE, >60 ELDERLY NOT WORKING HERE, see next
        if(age < 18){
            System.out.println("Too YOUNG to vote");
        } else if(age < 60) {
            System.out.println("You are WORKING age");
        }


        // IF-ELSEIF-ELSE
        // <18 TOO YOUNG, 18-60 WORKING AGE, >60 ELDERLY
        if(age < 18){
            System.out.println("Too YOUNG to vote");
        } else if(age < 60) {
            System.out.println("You are WORKING age");
        } else {
            System.out.println("You are ELDERLY, retiring soon?");
        }

        // IF-ELSEIF-ELSEIF-ELSE
        // <18 YOUTH, 18-25 YOUNG-ADULT, 26-60 ADULT, >60 ELDERLY
        if(age < 18){
            System.out.println("You are YOUNG");
        } else if(age < 25) {
            System.out.println("You are a YOUNG-ADULT");
        } else if(age < 60) {
            System.out.println("You are an ADULT");
        } else {
            System.out.println("You are ELDERLY");
        }

        // Overly Verbose - Can be shortened
        // IF-ELSEIF-ELSEIF-ELSE
        // 0<18 YOUTH, 18<25 YOUNG-ADULT, 26<60 ADULT, >=60 ELDERLY
        if(age >= 0 && age < 18){
            System.out.println("You are YOUNG");
        } else if(age >= 18 && age < 25) {
            System.out.println("You are a YOUNG-ADULT");
        } else if(age >= 25 && age < 60) {
            System.out.println("You are an ADULT");
        } else {
            System.out.println("You are ELDERLY");
        }

        if(age == 32) {
            System.out.println("You are the same age as Teacherman, what's your name?");
            String name = input.next();
            if(name.equals("Jermaine")) {
                System.out.println("Omg, you're Teacherman!");
            }else{
                System.out.println("oh, ok. I thought you were someone else.");
            }
        }
    }

}

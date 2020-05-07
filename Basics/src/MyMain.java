public class MyMain {

    public static void main(String[] args){
        System.out.println("Hello world");

        int yourAge = 10;
        int myAge = 20;
        int ourAges = yourAge / myAge;

        // Your age is 10
        yourAge = yourAge + 2;

        yourAge ++;
        yourAge --;
        yourAge += 10;
        yourAge -= 10;

        boolean edisonIsOld = true;
        int edisonAge = 4;

        edisonIsOld = edisonAge > 10;

        boolean bothTrue = 42 == 42;
        boolean oneTOneF = 42 != 79;

        boolean thisIsTrue = true;
        thisIsTrue = !thisIsTrue;
        thisIsTrue = !thisIsTrue;
        thisIsTrue = !thisIsTrue;
        thisIsTrue = !thisIsTrue;
        thisIsTrue = !thisIsTrue;
        thisIsTrue = !thisIsTrue;
        thisIsTrue = !thisIsTrue;
        thisIsTrue = !thisIsTrue;

        boolean a = true;
        boolean b = false;

        boolean c = a && b; // True if both a and b are true
        boolean d = a || b; // True if at least one of a or b are true

        int bigNum = Integer.MAX_VALUE;
        boolean boo = Boolean.TRUE;
        char chacha = Character.forDigit(50, 10);
        byte bb = Byte.valueOf("a");
        float ff = Float.MAX_VALUE;
        double dd = Double.MIN_VALUE;

        Cat cat = new Cat();
        cat.name = "Bob";

        if(edisonAge > 3) {
            System.out.println("Edison is full grown");
        }else {
            System.out.println("Edison is still growing");
        }

    }

    static class Cat{
        String name;
    }

}

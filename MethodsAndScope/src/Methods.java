public class Methods {

    static int yellCount = 0;

    public static void main(String[] args) {
        // Basic method
        int total = sum(3,4);
        System.out.println(total);

        // Void method
        yell("How are things? I am fine. This is fine.");
        // Methods that return values do not need to be assigned to anything
        sum(5,6);

        // Method overloading
        yell("Brick Tamland","I love lamp");

        System.out.println("Yelled " + yellCount + " times");
    }

    // int sum(int,int)
    static int sum(int n1, int n2) {
        return n1 + n2;
    }

    // yell(String)
    static void yell(String words) {
        yell("UNKNOWN", words);
    }
    // yell(String,String)
    static void yell(String speaker, String words) {
        yellCount++;
        System.out.println(speaker + ": " + words.toUpperCase());
    }

    // chickenOrEgg(int,boolean)
    static void chickenOrEgg(int chickens, boolean hatched) {
        if(hatched){
            System.out.println("Chicken# :" + chickens);
        }else{
            System.out.println("Don't count your chickens before they hatch");
        }
    }

    // chickenOrEgg(boolean,int)
    static void chickenOrEgg(boolean hatched, int chickens) {
        if(hatched){
            System.out.println("Chicken# :" + chickens);
        }else{
            System.out.println("Don't count your chickens before they hatch");
        }
    }

}

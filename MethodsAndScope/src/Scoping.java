public class Scoping {

    static int d = 7;

    public static void main(String[] args){
        int a = 42;

        if(a == 42) {
            int b = 678;
            print(a,b,0,d);
            while (b > 675){
                int c = a + b;
                print(a,b,c,d);
                b--;
            }
        }
        print(a,0,0,d);

    }
    static void print(int a, int b, int c, int d) {
        System.out.println(
                "a: " + a
                + "\nb: " + b
                + "\nc: " + c
                + "\nd: " + d);
    }

}
